package com.jditest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.jditest.JDI.openSite;
import static com.jditest.LoggerTypes.SLF4J;
import static com.jditest.jsbuilder.QueryLogger.ALL;
import static com.jditest.jsbuilder.QueryLogger.LOG_QUERY;
import static com.jditest.jswraper.DriverManager.CHROME_OPTIONS;
import static com.jditest.jswraper.DriverManager.killDrivers;
import static com.jditest.tools.TestIDLocators.ID_LOCATOR;
import static com.jditest.tools.TestIDLocators.SMART_LOCATOR;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        SMART_LOCATOR = ID_LOCATOR;
        CHROME_OPTIONS = cap -> cap.addArguments("--headless");
        JDI.LOGGER_TYPE = SLF4J;
        LOG_QUERY = ALL;
        openSite("https://jdi-testing.github.io/jdi-light");
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }
}
