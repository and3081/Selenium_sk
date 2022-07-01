package ru.vasyukov.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Page класс страницы https://skillfactory.ru/
 */
@SuppressWarnings("FieldCanBeLocal")
public class PageSkillMain extends BasePage {
    private final String XPATH_FOOTER_TEXT = "//div[@id='t-footer']//*[contains(text(),'{TEXT}')]";
    private final String XPATH_H1 = "//h1[text()]";
    private final String XPATH_POPULAR_COURSES_ALL =
            "//div[h2[text()='Популярные курсы']]/..//a[@class='tn-atom' and @href='{HREF}']";
    private final String XPATH_POPULAR_COURSES =
            "//div[h2[text()='Популярные курсы']]/..//a[@href='{HREF}']";
    private final String XPATH_BUTT_CONSULT =
            "//button[text()='Получить консультацию']";
    private final String XPATH_INPUT_NAME =
            "//div[div[./button[text()='Получить консультацию']]]//input[@name='name']";
    private final String XPATH_INPUT_NAME_ERR =
            "//div[div[./button[text()='Получить консультацию']]]//div[input[@name='name']]//div[@class='t-input-error']";
    private final String XPATH_INPUT_EMAIL =
            "//div[div[./button[text()='Получить консультацию']]]//input[@name='email']";
    private final String XPATH_INPUT_EMAIL_ERR =
            "//div[div[./button[text()='Получить консультацию']]]//div[input[@name='email']]//div[@class='t-input-error']";
    private final String XPATH_INPUT_TEL =
            "//div[div[./button[text()='Получить консультацию']]]//input[@type='tel']";
    private final String XPATH_INPUT_TEL_ERR =
            "//div[div[./button[text()='Получить консультацию']]]//div[input[@type='tel']]/..//div[@class='t-input-error']";
    private final String XPATH_ALL_COURSES =
            "//a[@class='tn-atom' and @href='/catalogue' and text()='Все курсы']";

    @Step("Проверить фрагмент title страницы '{title}'")
    public PageSkillMain checkTitleMain(String title) {
        checkTitleFragment(title);
        return this;
    }

    @Step("Проверка текста в футере '{text}'")
    public PageSkillMain checkFooterText(String text) {
        waitVisibleXpath(XPATH_FOOTER_TEXT.replace("{TEXT}", text), text);
        return this;
    }

    @Step("Проверка заголовка h1 '{text}'")
    public PageSkillMain checkH1Text(String text) {
        waitVisibleXpath(XPATH_H1, "Заголовок '" + text + "'");
        String txt = driver.findElement(By.xpath(XPATH_H1)).getText();
        Assertions.assertEquals(text, txt, "Заголовок h1 страницы неправильный");
        return this;
    }

    @Step("Клик ссылки '{ref}'")
    public PageSkillMain clickRefAll(String ref) {
        String xpath = XPATH_POPULAR_COURSES_ALL.replace("{HREF}", ref);
        WebElement el = waitVisibleClickableXpath(xpath, ref);
        waitRealClick(el, xpath);
        return this;
    }

    @Step("Клик ссылки '{ref}'")
    public PageSkillMain clickRef(String ref) {
        String xpath = XPATH_POPULAR_COURSES.replace("{HREF}", ref);
        WebElement el = waitVisibleClickableXpath(xpath, ref);
        waitRealClick(el, xpath);
        return this;
    }

    @Step("Клик 'Получить консультацию'")
    public PageSkillMain clickConsult() {
        WebElement el = waitVisibleClickableXpath(XPATH_BUTT_CONSULT, "Получить консультацию");
        waitRealClick(el, XPATH_BUTT_CONSULT);
        return this;
    }

    @Step("Клик 'Все курсы'")
    public PageSkillMain clickAllCourses() {
        WebElement el = waitVisibleClickableXpath(XPATH_ALL_COURSES, "Все курсы");
        waitRealClick(el, XPATH_ALL_COURSES);
        return this;
    }

    @Step("Ввод в поле Имя '{name}'")
    public PageSkillMain inputName(String name) {
        waitVisibleInput(XPATH_INPUT_NAME, name, "Имя");
        return this;
    }

    @Step("Текст ошибки Имя '{errorText}'")
    public PageSkillMain nameError(String errorText, String errorTextEn) {
        String err = "";
        if (waitXpathAttributeContain(XPATH_INPUT_NAME_ERR, "style", "opacity", "Имя/ошибка")) {
            err = waitPresenceXpath(XPATH_INPUT_NAME_ERR, "Имя/ошибка").getText();
        }
        if (!err.equals(errorText) && !err.equals(errorTextEn)) {
            Assertions.assertEquals(errorText, err, "Должна быть ошибка");
        }
        return this;
    }

    @Step("Ввод в поле Email '{email}'")
    public PageSkillMain inputEmail(String email) {
        waitVisibleInput(XPATH_INPUT_EMAIL, email, "Email");
        return this;
    }

    @Step("Текст ошибки Email '{errorText}'")
    public PageSkillMain emailError(String errorText, String errorTextEn) {
        String err = "";
        if (waitXpathAttributeContain(XPATH_INPUT_EMAIL_ERR, "style", "opacity", "Email/ошибка")) {
            err = waitPresenceXpath(XPATH_INPUT_EMAIL_ERR, "Email/ошибка").getText();
        }
        if (!err.equals(errorText) && !err.equals(errorTextEn)) {
            Assertions.assertEquals(errorText, err, "Должна быть ошибка");
        }
        return this;
    }

    @Step("Ввод в поле Телефон '{tel}'")
    public PageSkillMain inputTel(String tel) {
        waitVisibleInput(XPATH_INPUT_TEL, tel, "Телефон");
        return this;
    }

    @Step("Текст ошибки Телефон '{errorText}'")
    public PageSkillMain telError(String errorText, String errorTextEn) {
        String err = "";
        if (waitXpathAttributeContain(XPATH_INPUT_TEL_ERR, "style", "opacity", "Телефон/ошибка")) {
            err = waitPresenceXpath(XPATH_INPUT_TEL_ERR, "Телефон/ошибка").getText();
        }
        if (!err.equals(errorText) && !err.equals(errorTextEn)) {
            Assertions.assertEquals(errorText, err, "Должна быть ошибка");
        }
        return this;
    }
}
