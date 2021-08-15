package com.jdiai;

import com.jdiai.jsbuilder.ListSearch;
import com.jdiai.jsdriver.JSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.jdiai.DriverManager.*;
import static com.jdiai.LocatorUtils.defineLocator;
import static com.jdiai.jsbuilder.ListSearch.CHAIN;
import static com.jdiai.jsbuilder.ListSearch.MULTI;
import static com.jdiai.jsbuilder.QueryLogger.ALL;
import static com.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static java.util.Arrays.stream;

public interface TestInit {
    default JSDriver js(String locator) {
        JSDriver driver = new JSDriver(driver(), defineLocator(locator));
        driver.strategy = CHAIN;
        return driver;
    }
    default JSDriver jsMulti(String locator) {
        JSDriver driver = new JSDriver(driver(), defineLocator(locator));
        driver.strategy = MULTI;
        return driver;
    }
    default JSDriver js(String... locators) {
        By[] list = stream(locators).map(LocatorUtils::defineLocator).toArray(By[]::new);
        JSDriver driver = new JSDriver(driver(), list);
        driver.strategy = CHAIN;
        return driver;
    }
    default JSDriver jsMulti(String... locators) {
        By[] list = stream(locators).map(LocatorUtils::defineLocator).toArray(By[]::new);
        JSDriver driver = new JSDriver(driver(), list);
        driver.strategy = MULTI;
        return driver;
    }

    default String[] withParent(String locator) {
        return new String[] {".uui-header", ".profile-photo", locator };
    }
    default String[] inForm(String locator) {
        return new String[] {".uui-header", "form", locator };
    }

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        initDriver();
        LOG_QUERY.set(ALL);
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }

}
