package ru.vasyukov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.vasyukov.hooks.WebHooks;
import ru.vasyukov.pages.PageSkillMain;

/**
 * Класс тест-кейсов
 * @author Васюков А.Ю.  GitHub  https://github.com/and3081/Selenium_SberAST_b
 * @version 1.0
 * Описание тест-кейса:
 * 1. сайт https://www.sberbank-ast.ru госзакупки
 * 2. проверить title
 * 3. запрос "Страхование"
 * 4. вывести инфо о первых 10 заказах удовлетворяющих условиям:
 *    цена > 600 тыс. руб,
 *    тип Госзакупки по 44-ФЗ.
 *    Проверять только первые 120 результатов в списке.
 * 5. проверить количество фактической выборки
 * 6. В инфо выводить: название, цену, номер (в консоль, в Step аллюра),
 *    Json-attachment в аллюр.
 *
 * Настраиваемые листенеры в проперти:
 *       - какие типы методов скринить: драйвер, элементы, все варианты или отключить
 *       - какие выборочно по названиям методы скринить
 *       - какие скрины вокруг методов делать: перед, после, оба
 *       - при скрининге элементов:     всё окно, только элемент или оба скрина сразу
 *
 *       В аллюре скрины подписаны- перед и после какого метода, аргументы и возврат метода
 *
 *       - выбор браузера в проперти для прогона тестов:  Chrome, Edge
 */
public class Tests extends WebHooks {
    @DisplayName("Тестирование title, телефонов, email")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill01")
    public void testSkill01(String title, String tlf1, String tlf2, String email) {
        PageSkillMain.openPageMain(driver)
                .checkTitleMain(title)
                .checkFooterText(tlf1)
                .checkFooterText(tlf2)
                .checkFooterText(email);
    }

}
