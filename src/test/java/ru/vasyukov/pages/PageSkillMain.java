package ru.vasyukov.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

/**
 * Page класс страницы https://www..ru/
 */
@SuppressWarnings("FieldCanBeLocal")
public class PageSkillMain extends BasePage {
    private final String XPATH_FOOTER_TEXT = "//div[@id='t-footer']//*[contains(text(),'{TEXT}')]";
    private final String XPATH_H1 = "//h1[text()]";
    private final String XPATH_POPULAR_COURSES_ALL =
            "//div[h2[text()='Популярные курсы']]/..//a[@class='tn-atom' and @href='{HREF}']";
    private final String XPATH_POPULAR_COURSES =
            "//div[h2[text()='Популярные курсы']]/..//a[@href='{HREF}']";

    /**
     * Шаг Проверить фрагмент title страницы
     * @param title фрагмент title
     */
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
//        System.out.println("|"+text+"|");
        String txt = driver.findElement(By.xpath(XPATH_H1)).getText();
//        System.out.println("|"+txt+"|");
        Assertions.assertEquals(text, txt, "Заголовок h1 страницы неправильный");
        return this;
    }

    @Step("Клик ссылки '{ref}'")
    public PageSkillMain clickRefAll(String ref) {
        System.out.println(XPATH_POPULAR_COURSES_ALL.replace("{HREF}", ref));
        waitVisibleClickableXpath(XPATH_POPULAR_COURSES_ALL.replace("{HREF}", ref), ref).click();
        return this;

    }@Step("Клик ссылки '{ref}'")
    public PageSkillMain clickRef(String ref) {
        System.out.println(XPATH_POPULAR_COURSES.replace("{HREF}", ref));
        waitVisibleClickableXpath(XPATH_POPULAR_COURSES.replace("{HREF}", ref), ref).click();
        return this;
    }
}
