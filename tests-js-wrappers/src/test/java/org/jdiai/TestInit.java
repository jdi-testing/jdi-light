package org.jdiai;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.jdiai.jsbuilder.QueryLogger.ALL;
import static org.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static org.jdiai.jswraper.DriverManager.CHROME_OPTIONS;
import static org.jdiai.jswraper.DriverManager.killDrivers;

public interface TestInit {
    default String[] withParent(String locator) {
        return new String[] {".uui-header", ".profile-photo", locator };
    }
    default String[] inForm(String locator) {
        return new String[] {".uui-header", "form", locator };
    }

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        CHROME_OPTIONS = cap -> cap.addArguments("--headless");
        LOG_QUERY = ALL;
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }

}
