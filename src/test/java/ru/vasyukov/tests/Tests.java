package ru.vasyukov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.vasyukov.custom.properties.TestData;
import ru.vasyukov.hooks.WebHooks;
import ru.vasyukov.pages.PageSkillMain;

import java.util.List;

/**
 * Класс тест-кейсов
 * @author Васюков А.Ю.  GitHub  https://github.com/and3081/Selenium_sk
 * @version 1.0
 * Описание : проверки для https://skillfactory.ru/
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

    @DisplayName("Тестирование /catalogue")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill02")
    public void testSkill02(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRefAll(TestData.application.baseUrlSkillfactory()+TestData.application.endCatalog())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /start-it-specialist-proforientaciya")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill03")
    public void testSkill03(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endStartIt())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /data-scientist-pro")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill04")
    public void testSkill04(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endDataScientist())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /data-science-specialization")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill05")
    public void testSkill05(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endDataScience())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /data-analyst-pro")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill06")
    public void testSkill06(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endDataAnalystPro())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /data-analytics")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill07")
    public void testSkill07(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endDataAnalytics())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /qa-engineer-python-testirovshchik-programmnogo-obespecheniya")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill08")
    public void testSkill08(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endQaPython())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /python-fullstack-web-developer")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill09")
    public void testSkill09(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endPythonFullstack())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /web-developer")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill10")
    public void testSkill10(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endWebDeveloper())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /python-developer")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill11")
    public void testSkill11(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endPythonDeveloper())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /game-razrabotchik-na-unity-i-c-sharp")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill12")
    public void testSkill12(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endGameDeveloper())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /game-developer-pro")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill13")
    public void testSkill13(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endGameDeveloperPro())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /java-qa-engineer-testirovshik-po")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill14")
    public void testSkill14(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endQaJava())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /java-razrabotchik")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill15")
    public void testSkill15(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endJavaDeveloper())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование /qa-engineer-po-ruchnomu-testirovaniyu")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill16")
    public void testSkill16(String titleH1) {
        PageSkillMain.openPageMain(driver)
                .clickRef(TestData.application.baseUrlSkillfactory()+TestData.application.endQaManual())
                .checkH1Text(titleH1);
    }

    @DisplayName("Тестирование ввода неправильного имени")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill17")
    public void testSkill17(String name, String errorText, String errorTextEn) {
        PageSkillMain.openPageMain(driver)
                .inputName(name)
                .clickConsult()
                .nameError(errorText, errorTextEn);
    }

    @DisplayName("Тестирование ввода неправильного email")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill18")
    public void testSkill18(String email, String errorText, String errorTextEn) {
        PageSkillMain.openPageMain(driver)
                .inputEmail(email)
                .clickConsult()
                .emailError(errorText, errorTextEn);
    }

    @DisplayName("Тестирование ввода неправильного телефона")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill19")
    public void testSkill19(String tel, String errorText, String errorTextEn) {
        PageSkillMain.openPageMain(driver)
                .inputTel(tel)
                .clickConsult()
                .telError(errorText, errorTextEn);
    }

    @DisplayName("Тестирование ввода короткого телефона")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill20")
    public void testSkill20(String tel, String errorText, String errorTextEn) {
        PageSkillMain.openPageMain(driver)
                .inputTel(tel)
                .clickConsult()
                .telError(errorText, errorTextEn);
    }

    @DisplayName("Тестирование пустого ввода")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill21")
    public void testSkill21(String errorText, String errorTextEn) {
        PageSkillMain.openPageMain(driver)
                .clickConsult()
                .nameError(errorText, errorTextEn)
                .emailError(errorText, errorTextEn)
                .telError(errorText, errorTextEn);
    }

    @DisplayName("Тестирование выборки в /catalogue")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerSkill22")
    public void testSkill22(String item, String checkItem, List<String> hrefs) {
        PageSkillMain.openPageMain(driver)
                .clickAllCourses()
                .nextPageAllCourses()
                .clickAllCourses()
                .clickAllCourses(item)
                .checkResult(checkItem, hrefs);
    }
}
