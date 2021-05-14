package com.jditest;

import com.jditest.jsdriver.JSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.util.Arrays.stream;
import static com.jditest.DriverManager.*;
import static com.jditest.LocatorUtils.defineLocator;
import static com.jditest.jsbuilder.QueryLogger.ALL;
import static com.jditest.jsbuilder.QueryLogger.LOG_QUERY;

public interface TestInit {
    default JSDriver js(String locator) {
        return new JSDriver(driver(), defineLocator(locator));
    }
    default JSDriver js(String... locators) {
        By[] list = stream(locators).map(LocatorUtils::defineLocator).toArray(By[]::new);
        return new JSDriver(driver(), list);
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
        LOG_QUERY = ALL;
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }

}
