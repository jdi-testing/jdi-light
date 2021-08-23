package com.jdiai;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.jdiai.JDI.openSite;
import static com.jdiai.LoggerTypes.SLF4J;
import static com.jdiai.jsbuilder.QueryLogger.ALL;
import static com.jdiai.jswraper.driver.DriverManager.killDrivers;
import static com.jdiai.jswraper.driver.JDIDriver.DRIVER_OPTIONS;
import static com.jdiai.tools.TestIDLocators.ID_LOCATOR;
import static com.jdiai.tools.TestIDLocators.SMART_LOCATOR;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        SMART_LOCATOR = ID_LOCATOR;
        DRIVER_OPTIONS.chrome = cap -> cap.addArguments("--headless");
        JDI.LOGGER_TYPE = SLF4J;
        JDI.logJSRequests(ALL);
        openSite("https://jdi-testing.github.io/jdi-light");
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }
}
