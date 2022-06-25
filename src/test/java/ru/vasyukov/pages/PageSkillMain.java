package ru.vasyukov.pages;

import io.qameta.allure.Step;

/**
 * Page класс страницы https://www..ru/
 */
@SuppressWarnings("FieldCanBeLocal")
public class PageSkillMain extends BasePage {
    private final String XPATH_FOOTER_TEXT = "//div[@id='t-footer']//*[contains(text(),'{TEXT}')]";

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
}
