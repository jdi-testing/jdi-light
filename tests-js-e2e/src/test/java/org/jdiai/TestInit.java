package org.jdiai;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.jdiai.DriverManager.initDriver;
import static org.jdiai.DriverManager.killDrivers;
import static org.jdiai.jsbuilder.JSBuilder.LOG_QUERY;
import static org.jdiai.tools.JSTalk.openSite;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        initDriver();
        openSite("https://jdi-testing.github.io/jdi-light");
        LOG_QUERY = true;
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }
}
