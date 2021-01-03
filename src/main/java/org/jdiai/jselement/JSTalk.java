package org.jdiai.jselement;

import com.epam.jdi.tools.Safe;
import org.jdiai.jsbuilder.JSBuilder;
import org.jdiai.jsbuilder.SmartBuilderActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.Arrays.stream;

public class JSTalk {
    public static Safe<WebDriver> DRIVER = new Safe<>(JSTalk::initDriver);
    public static JSSmart $(String locator) {
        return new JSSmart(DRIVER.get(), defineLocator(locator));
    }
    public static JSSmart $(String... locators) {
        return new JSSmart(DRIVER.get(), locatorsToBy(locators));
    }
    public static <T> JSEntity<T> $(Class<T> cl, String locator) {
        JSEntity<T> entity = new JSEntity<T>(DRIVER.get(), defineLocator(locator)).initClass(cl);
        entity.driver.setBuilder(new JSBuilder(DRIVER.get(), new SmartBuilderActions()));
        return entity;
    }
    public static <T> JSEntity<T> $(Class<T> cl, String... locators) {
        JSEntity<T> entity = new JSEntity<T>(DRIVER.get(), locatorsToBy(locators)).initClass(cl);
        entity.driver.setBuilder(new JSBuilder(DRIVER.get(), new SmartBuilderActions()));
        return entity;
    }
    public static JSElement element(String locator) {
        return new JSElement(DRIVER.get(), defineLocator(locator));
    }
    public static JSElement element(String... locators) {
        return new JSElement(DRIVER.get(), locatorsToBy(locators));
    }
    public static <T> JSEntity<T> element(Class<T> cl, String locator) {
        return new JSEntity<T>(DRIVER.get(), defineLocator(locator)).initClass(cl);
    }
    public static <T> JSEntity<T> element(Class<T> cl, String... locators) {
        return new JSEntity<T>(DRIVER.get(), locatorsToBy(locators)).initClass(cl);
    }
    public static JSJson json(String locator) {
        return new JSJson(DRIVER.get(), defineLocator(locator));
    }
    public static JSJson json(String... locators) {
        return new JSJson(DRIVER.get(), locatorsToBy(locators));
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
