package ru.vasyukov.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Page класс страницы https://skillfactory.ru/catalogue
 */
@SuppressWarnings("FieldCanBeLocal")
public class PageAllCourses extends BasePage {
    private final String XPATH_BUTTON_DIRECTION_ALL =
            "//div[text()='Направление']/following-sibling::div//button[./span[text()='Показать все']]";
    private final String XPATH_ITEM_DIRECTION =
            "//div[text()='Направление']/following-sibling::div//div[text()='{ITEM}']";
    private final String XPATH_RESULTS =
            "//div[@class[contains(.,'t951__grid-cont')]]/div/a[@href[contains(.,'{ITEM}')]]";

    @Step("Клик Направление 'Показать все'")
    public PageAllCourses clickAllCourses() {
        WebElement el = waitVisibleClickableXpath(XPATH_BUTTON_DIRECTION_ALL, "Направление 'Показать все'");
        waitRealClick(el, XPATH_BUTTON_DIRECTION_ALL);
        return this;
    }

    @Step("Клик итем Направления '{item}'")
    public PageAllCourses clickAllCourses(String item) {
        String xpath = XPATH_ITEM_DIRECTION.replace("{ITEM}", item);
        WebElement el = waitVisibleClickableXpath(xpath, "Направление '"+ item +"'");
        waitRealClick(el, xpath);
        return this;
    }

    @Step("Проверка результатов выборки '{item}' '{hrefs}'")
    public PageAllCourses checkResult(String item, List<String> hrefs) {
        List<String> els = waitPresenceList(XPATH_RESULTS.replace("{ITEM}", item),
                "Выборка '"+ item +"'").stream()
                .map(el-> el.getAttribute("href"))
                .collect(Collectors.toList());
        Assertions.assertTrue(els.containsAll(hrefs), "В результатах должны быть все ссылки");
        return this;
    }
}
