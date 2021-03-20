package org.jdiai;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.jdiai.DriverManager.initDriver;
import static org.jdiai.DriverManager.killDrivers;
import static org.jdiai.JSTalk.openSite;
import static org.jdiai.jsbuilder.QueryLogger.ALL;
import static org.jdiai.jsbuilder.QueryLogger.LOG_QUERY;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        initDriver();
        openSite("https://jdi-testing.github.io/jdi-light");
        LOG_QUERY = ALL;
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }

}
