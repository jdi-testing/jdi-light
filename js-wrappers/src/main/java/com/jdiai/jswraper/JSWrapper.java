package com.jdiai.jswraper;

import com.epam.jdi.tools.Safe;
import com.jdiai.jsbuilder.SmartBuilderActions;
import com.jdiai.jswraper.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import static com.jdiai.jswraper.JSWrappersUtils.NAME_TO_LOCATOR;
import static com.jdiai.jswraper.JSWrappersUtils.locatorsToBy;

public class JSWrapper {
    public static Safe<WebDriver> DRIVER = new Safe<>(DriverManager::chromeDriver);
    public static WebDriver driver() {
        return DRIVER.get();
    }

    public static JSSmart $w(String locator) {
        return new JSSmart(driver(), NAME_TO_LOCATOR.execute(locator));
    }
    public static JSSmart $w(String... locators) {
        return new JSSmart(driver(), locatorsToBy(locators));
    }
    public static <T> JSEntity<T> $w(Class<T> cl, String locator) {
        JSEntity<T> entity = new JSEntity<T>(driver(), NAME_TO_LOCATOR.execute(locator)).initClass(cl);
        entity.driver.updateBuilderActions(new SmartBuilderActions());
        return entity;
    }
    public static <T> JSEntity<T> $w(Class<T> cl, String... locators) {
        JSEntity<T> entity = new JSEntity<T>(driver(), locatorsToBy(locators)).initClass(cl);
        entity.driver.updateBuilderActions(new SmartBuilderActions());
        return entity;
    }
    public static JSElement element(String locator) {
        return new JSElement(driver(), NAME_TO_LOCATOR.execute(locator));
    }
    public static JSElement element(String... locators) {
        return new JSElement(driver(), locatorsToBy(locators));
    }
    public static <T> JSEntity<T> element(Class<T> cl, String locator) {
        return new JSEntity<T>(driver(), NAME_TO_LOCATOR.execute(locator)).initClass(cl);
    }
    public static <T> JSEntity<T> element(Class<T> cl, String... locators) {
        return new JSEntity<T>(driver(), locatorsToBy(locators)).initClass(cl);
    }
    public static JSJson json(String locator) {
        return new JSJson(driver(), NAME_TO_LOCATOR.execute(locator));
    }
    public static JSJson json(String... locators) {
        return new JSJson(driver(), locatorsToBy(locators));
    }

}
