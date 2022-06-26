package ru.vasyukov.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.vasyukov.custom.properties.TestData;

import java.time.Duration;
import java.util.List;

/**
 * Класс родительского PO (общие xpath и методы, методы создания PO страниц)
 */
public class BasePage {
    /**
     * объект WebDriver
     */
    protected static WebDriver driver;
    /**
     * Значение явного ожидания ms из проперти
     */
    protected static long timeoutExplicitMs = Long.parseLong(TestData.browser.defaultTimeoutExplicitMs());
    /**
     * Объект явных ожиданий
     */
    protected static WebDriverWait wait;
    /**
     * Объект Actions
     */
    protected static Actions actions;

    /**
     * Инициализация объектов
     * @param driver веб-драйвер
     */
    private static void init(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(timeoutExplicitMs));
        actions = new Actions(driver);
    }

    @Step("Открыть стартовую страницу")
    public static PageSkillMain openPageMain(WebDriver driver) {
        init(driver);
        driver.get(TestData.application.baseUrlSkillfactory());
        return new PageSkillMain();
    }

    /**
     * Шаг Проверить фрагмент title страницы
     * @param title фрагмент title
     */
    @Step("Проверить фрагмент title страницы '{title}'")
    public void checkTitleFragment(String title) {
        myAssert(()->wait.until(ExpectedConditions.titleContains(title)),
                "Ожидание фрагмента title исчерпано: " + title);
    }

    /**
     * Ожидание видимости input-элемента, клик и ввод текста
     * @param xpath    xpath input-элемента
     * @param text     тест для ввода
     * @param message  доп.сообщение для ассерта
     * @return WebElement
     */
    public WebElement waitVisibleInput(String xpath, String text, String message) {
        WebElement el = myAssert(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))),
                "Ожидание видимости элемента исчерпано: " + message + ": " + xpath);
        waitRealClick(el, xpath);
        waitRealSend(el, xpath, text);
        return el;
    }

    /**
     * Ожидание видимости input-элемента, клик/очистка/ввод текста, Enter
     * @param xpath    xpath input-элемента
     * @param text     тест для ввода
     * @param message  доп.сообщение для ассерта
     * @return WebElement
     */
    public WebElement waitVisibleInputEnter(String xpath, String text, String message) {
        WebElement el = myAssert(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))),
                "Ожидание видимости элемента исчерпано: " + message + ": " + xpath);
        waitRealClick(el, xpath);
        el.clear();
        waitRealSend(el, xpath, text+Keys.ENTER);
        return el;
    }

    /**
     * Ожидание существования списка элементов
     * @param xpath    xpath элементов
     * @param message  доп.сообщение для ассерта
     * @return список WebElement
     */
    public List<WebElement> waitPresenceList(String xpath, String message) {
        return myAssert(()->wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))),
                "Ожидание существования списка элементов исчерпано: " + message + ": " + xpath);
    }

    /**
     * Ожидание существования элемента
     * @param xpath    xpath элемента
     * @param message  доп.сообщение для ассерта
     * @return WebElement
     */
    public WebElement waitPresenceXpath(String xpath, String message) {
        return myAssert(()->wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))),
                "Ожидание существования элемента исчерпано: " + message + ": " + xpath);
    }

    /**
     * Ожидание существования и видимости элемента
     * @param xpath    xpath элемента
     * @param message  доп.сообщение для ассерта
     * @return WebElement
     */
    public WebElement waitVisibleXpath(String xpath, String message) {
        return myAssert(()->wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))),
                "Ожидание видимости элемента исчерпано: " + message + ": " + xpath);
    }

    /**
     * Ожидание существования, видимости и кликабельности элемента
     * @param xpath    xpath элемента
     * @param message  доп.сообщение для ассерта
     * @return WebElement
     */
    public WebElement waitVisibleClickableXpath(String xpath, String message) {
        waitVisibleXpath(xpath, message);
        return myAssert(()->wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))),
                "Ожидание clickable элемента исчерпано: " + message + ": " + xpath);
    }

    /**
     * Ожидание существования элемента с атрибутом с фрагментом значения
     * @param xpath    xpath элемента
     * @param attr     атрибут
     * @param value    фрагмент значения
     * @param message  доп.сообщение для ассерта
     * @return WebElement
     */
    public boolean waitXpathAttributeContain(String xpath, String attr, String value, String message) {
        return myAssert(()->wait.until(ExpectedConditions.attributeContains(By.xpath(xpath),
                        attr, value)),
                "Ожидание существования элемента с аттрибутом: " + attr +"/"+ value +"/"+ message + ": " + xpath);
    }

    /**
     * Обертка для явных ожиданий
     * Все ожидания wait() обернуты в ассерт assertTimeoutPreemptively с таймаутом из проперти для:
     * - устраняется баг по цеплянию неявного ожидания
     * - при неуспехе wait() в аллюр отправляется свое сообщение, а не простыня исключения
     * @param supplier  оборачиваемый executable wait (лямбда supplier)
     *                  usage: ()->wait.until(...)
     * @param message   доп.сообщение для ассерта
     * @param <T>       параметризованный тип (определяется по supplier)
     * @return          при успехе транслирует возврат от условия wait()
     */
    private <T> T myAssert(ThrowingSupplier<T> supplier, String message) {
        return Assertions.assertTimeoutPreemptively(Duration.ofMillis(timeoutExplicitMs), supplier, message);
    }

    /**
     * Ожидание и выполнение реального клика, при ElementClickInterceptedException (перекрытие элемента)
     * отправляется ESC в фокус для попытки снятия попапа
     * @param el     элемент для клика
     * @param xpath  для попытки заново получить элемент
     * @return true- клик сделан
     */
    @SuppressWarnings("UnusedReturnValue")
    public boolean waitRealClick(WebElement el, String xpath) {
        boolean[] isClick = new boolean[]{false};
        boolean[] isCatch = new boolean[]{false};

        myAssert(() -> wait.until((ExpectedCondition<Boolean>) driver -> {
            try {
                if (isCatch[0]) {
                    assert driver != null;
                    driver.findElement(By.xpath(xpath)).click();  // попытка заново получить элемент
                } else {
                    el.click();
                }
            } catch (ElementClickInterceptedException e) {
                actions.sendKeys(Keys.ESCAPE).perform();  // попытка снять попап
                isCatch[0] = false;
                return false;
            } catch (Exception e) {
                isCatch[0] = true;
                return false;
            } isClick[0] = true; return true; }),
                "Ожидание клика на элемент исчерпано (клик чем-то закрыт)");
        return isClick[0];
    }

    /**
     * Ожидание и выполнение реального send
     * @param el     элемент для send
     * @param xpath  для попытки заново получить элемент
     * @param text   текст для send
     * @return true- send сделан
     */
    @SuppressWarnings("UnusedReturnValue")
    public boolean waitRealSend(WebElement el, String xpath, String text) {
        boolean[] isSend = new boolean[]{false};
        boolean[] isCatch = new boolean[]{false};

        myAssert(() -> wait.until((ExpectedCondition<Boolean>) driver -> {
                    try {
                        if (isCatch[0]) {
                            assert driver != null;
                            driver.findElement(By.xpath(xpath)).sendKeys(text);  // попытка заново получить элемент
                        } else {
                            el.sendKeys(text);
                        }
                    } catch (Exception e) {
                        isCatch[0] = true;
                        return false;
                    } isSend[0] = true; return true; }),
                "Ожидание send '"+ text +"' в элемент исчерпано");
        return isSend[0];
    }
}
