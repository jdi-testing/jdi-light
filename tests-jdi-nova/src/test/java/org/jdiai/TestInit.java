package org.jdiai;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.jdiai.JSTalk.openSite;
import static org.jdiai.jsbuilder.QueryLogger.ALL;
import static org.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static org.jdiai.jswraper.DriverManager.CHROME_OPTIONS;
import static org.jdiai.jswraper.DriverManager.killDrivers;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        CHROME_OPTIONS = cap -> cap.addArguments("--headless");
        openSite("https://jdi-testing.github.io/jdi-light");
        LOG_QUERY = ALL;
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }

}
