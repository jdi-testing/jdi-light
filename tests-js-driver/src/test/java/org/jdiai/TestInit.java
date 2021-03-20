package org.jdiai;

import org.jdiai.jsdriver.JSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.util.Arrays.stream;
import static org.jdiai.DriverManager.*;
import static org.jdiai.LocatorUtils.defineLocator;
import static org.jdiai.Pages.openSite;
import static org.jdiai.jsbuilder.QueryLogger.ALL;
import static org.jdiai.jsbuilder.QueryLogger.LOG_QUERY;

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
        openSite();
        LOG_QUERY = ALL;
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }

}
