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
        try {
            driver.get(TestData.application.baseUrlSkillfactory());
        } catch (TimeoutException e) {
            System.out.println("------- timeout: повторный get");
            driver.get(TestData.application.baseUrlSkillfactory());
        }
        return new PageSkillMain();
    }

    public PageAllCourses nextPageAllCourses() {
        return new PageAllCourses();
    }

    /**
     * Проверить фрагмент title страницы
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
                "Ожидание видимости элемента исчерпано: " + message + ":\n" + xpath);
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
                "Ожидание видимости элемента исчерпано: " + message + ":\n" + xpath);
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
                "Ожидание существования списка элементов исчерпано: " + message + ":\n" + xpath);
    }

    /**
     * Ожидание существования элемента
     * @param xpath    xpath элемента
     * @param message  доп.сообщение для ассерта
     * @return WebElement
     */
    public WebElement waitPresenceXpath(String xpath, String message) {
        return myAssert(()->wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))),
                "Ожидание существования элемента исчерпано: " + message + ":\n" + xpath);
    }

    /**
     * Ожидание невидимости/отсутствия элемента
     * @param xpath    xpath элемента
     * @param message  доп.сообщение для ассерта
     * @return true- невидим/отсутствует
     */
    public boolean waitNotPresenceXpath(String xpath, String message) {
        return myAssert(()->wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath))),
                "Ожидание невидимости/отсутствия элемента исчерпано: " + message + ":\n" + xpath);
    }

    /**
     * Проверка существования элемента без ожидания и ошибки
     * @param xpath    xpath элемента
     * @return true- существует
     */
    public boolean isElementPresent(String xpath) {
        return getAmountOfElements(xpath) > 0;
    }

    /**
     * Проверка количества элементов без ожидания и ошибки
     * @param xpath    xpath элемента
     * @return количество элементов
     */
    public int getAmountOfElements(String xpath) {
        return driver.findElements(By.xpath(xpath)).size();
    }

    /**
     * Ожидание существования и видимости элемента
     * @param xpath    xpath элемента
     * @param message  доп.сообщение для ассерта
     * @return WebElement
     */
    public WebElement waitVisibleXpath(String xpath, String message) {
        return myAssert(()->wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))),
                "Ожидание видимости элемента исчерпано: " + message + ":\n" + xpath);
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
                "Ожидание clickable элемента исчерпано: " + message + ":\n" + xpath);
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
                "Ожидание существования элемента с аттрибутом: " + attr +"/"+ value +"/"+ message + ":\n" + xpath);
    }

    /**
     * Обертка для явных ожиданий
     * Все ожидания wait() обернуты в ассерт assertTimeoutPreemptively с таймаутом из проперти для:
     * - устраняется баг по цеплянию неявного ожидания
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
//        int[] count = new int[]{0};

        myAssert(() ->new WebDriverWait(driver, Duration.ofMillis(timeoutExplicitMs))
                        .pollingEvery(Duration.ofMillis(200))
                        .ignoreAll(List.of(TimeoutException.class))
                        .until((ExpectedCondition<Boolean>) driver -> {
                            try {
//                                count[0]++;
//                                System.out.println("------- click N: "+count[0]);
                                el.click();
                            } catch (ElementClickInterceptedException e) {
//                                System.out.println("------- click перекрыт: "+xpath);
                                actions.sendKeys(Keys.ESCAPE).perform();  // попытка снять попап
                                return false;
                            } catch (Exception e) {
//                                System.out.println("------- click refind/click: "+xpath);
                                assert driver != null;
                                driver.findElement(By.xpath(xpath)).click();  // попытка заново получить элемент
                                return false;
                            }
                            isClick[0] = true;
                            return true; }),
                "Ожидание клика на элемент исчерпано (возможно элемент чем-то закрыт):\n" + xpath);
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

        myAssert(() -> new WebDriverWait(driver, Duration.ofMillis(timeoutExplicitMs))
                        .pollingEvery(Duration.ofMillis(200))
                        .ignoreAll(List.of(TimeoutException.class))
                        .until((ExpectedCondition<Boolean>) driver -> {
                            try {
                                el.sendKeys(text);
                            } catch (Exception e) {
                                assert driver != null;
                                driver.findElement(By.xpath(xpath)).sendKeys(text);  // попытка заново получить элемент
                                return false;
                            }
                            isSend[0] = true;
                            return true; }),
                "Ожидание send '"+ text +"' в элемент исчерпано:\n" + xpath);
        return isSend[0];
    }
}
