package com.jdiai.jswraper;

import com.epam.jdi.tools.Safe;
import com.jdiai.jswraper.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import static com.jdiai.jswraper.JSWrappersUtils.NAME_TO_LOCATOR;
import static com.jdiai.jswraper.JSWrappersUtils.locatorsToBy;

public class JSWrapper {
    public static Safe<WebDriver> DRIVER = new Safe<>(DriverManager::getDriver);
    public static String displayedFilter = "element !== null && styles.visibility === 'visible' && styles.display !== 'none' && !element.hasAttribute('hidden')";

    public static WebDriver driver() {
        return DRIVER.get();
    }

    public static JSBaseEngine $w(String locator) {
        return new JSBaseEngine(driver(), NAME_TO_LOCATOR.apply(locator));
    }
    public static JSBaseEngine $wf(String locator) {
        JSBaseEngine element = new JSBaseEngine(driver(), NAME_TO_LOCATOR.apply(locator));
        element.jsDriver().builder().setFilter(displayedFilter);
        return element;
    }

    public static JSBaseEngine $w(String... locators) {
        return new JSBaseEngine(driver(), locatorsToBy(locators));
    }

    public static JSBaseEngine $wf(String... locators) {
        JSBaseEngine element = new JSBaseEngine(driver(), locatorsToBy(locators));
        element.jsDriver().builder().setFilter(displayedFilter);
        return element;
    }
    public static <T> JSEntity<T> $w(Class<T> cl, String locator) {
        return new JSEntity<T>(driver(), NAME_TO_LOCATOR.apply(locator)).initClass(cl);
    }
    public static <T> JSEntity<T> $wf(Class<T> cl, String locators) {
        JSEntity<T> entity = new JSEntity<T>(driver(), locatorsToBy(locators)).initClass(cl);
        entity.jsDriver().builder().setFilter(displayedFilter);
        return entity;
    }

    public static <T> JSEntity<T> $w(Class<T> cl, String... locators) {
        return new JSEntity<T>(driver(), locatorsToBy(locators)).initClass(cl);
    }
    public static <T> JSEntity<T> $wf(Class<T> cl, String... locators) {
        JSEntity<T> entity = new JSEntity<T>(driver(), locatorsToBy(locators)).initClass(cl);
        entity.jsDriver().builder().setFilter(displayedFilter);
        return entity;
    }

    public static JSElement element(String locator) {
        return new JSElement(driver(), NAME_TO_LOCATOR.apply(locator));
    }

    public static JSElement element(String... locators) {
        return new JSElement(driver(), locatorsToBy(locators));
    }

    public static <T> JSEntity<T> element(Class<T> cl, String locator) {
        return new JSEntity<T>(driver(), NAME_TO_LOCATOR.apply(locator)).initClass(cl);
    }

    public static <T> JSEntity<T> element(Class<T> cl, String... locators) {
        return new JSEntity<T>(driver(), locatorsToBy(locators)).initClass(cl);
    }

    public static JSJson json(String locator) {
        return new JSJson(driver(), NAME_TO_LOCATOR.apply(locator));
    }

    public static JSJson json(String... locators) {
        return new JSJson(driver(), locatorsToBy(locators));
    }
}
