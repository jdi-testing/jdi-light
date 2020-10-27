package org.jdiai.jselement;

import com.epam.jdi.tools.Safe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.Arrays.stream;

public class JSTalk {
    public static Safe<WebDriver> DRIVER = new Safe<>(JSTalk::initDriver);
    public static JSElement $(String locator) {
        return new JSElement(DRIVER.get(), defineLocator(locator));
    }
    public static JSElement $(String... locators) {
        return new JSElement(DRIVER.get(), locatorsToBy(locators));
    }
    public static JSJson json(String locator) {
        return new JSJson(DRIVER.get(), defineLocator(locator));
    }
    public static JSJson json(String... locators) {
        return new JSJson(DRIVER.get(), locatorsToBy(locators));
    }
    public static <T> JSObject<T> entity(Class<T> cl, String locator) {
        return new JSObject<T>(DRIVER.get(), defineLocator(locator)).initClass(cl);
    }
    public static <T> JSObject<T> entity(Class<T> cl, String... locators) {
        return new JSObject<T>(DRIVER.get(), locatorsToBy(locators)).initClass(cl);
    }
    public static JSObject<?> entity(String locator) {
        return new JSObject<>(DRIVER.get(), defineLocator(locator));
    }
    public static JSObject<?> entity(String... locators) {
        return new JSObject<>(DRIVER.get(), locatorsToBy(locators));
    }

    private static WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        return new ChromeDriver();
    }
    public static By[] locatorsToBy(String... locators) {
        return stream(locators).map(JSTalk::defineLocator).toArray(By[]::new);
    }
    public static By defineLocator(String locator) {
        return locator.contains("//")
                ? By.xpath(locator)
                : By.cssSelector(locator);
    }
}
