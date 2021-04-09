package org.jdiai;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.jdiai.JDI.openSite;
import static org.jdiai.jsbuilder.QueryLogger.ALL;
import static org.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static org.jdiai.jswraper.DriverManager.CHROME_OPTIONS;
import static org.jdiai.jswraper.DriverManager.killDrivers;
import static org.jdiai.tools.TestIDLocators.ID_LOCATOR;
import static org.jdiai.tools.TestIDLocators.SMART_LOCATOR;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        SMART_LOCATOR = ID_LOCATOR;
        // CHROME_OPTIONS = cap -> cap.addArguments("--headless");
        LOG_QUERY = ALL;
        openSite("https://jdi-testing.github.io/jdi-light");
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }
}
