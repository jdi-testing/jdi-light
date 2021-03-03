package org.jdiai.tests.jsdriver.flow;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.jdiai.jsdriver.jsbuilder.JSBuilder.LOG_QUERY;
import static org.jdiai.tests.jsdriver.TestInit.killDrivers;
import static org.jdiai.tools.JSTalk.*;

public interface FlowInit {
    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        DOMAIN = "https://jdi-testing.github.io/jdi-light";
        LOG_QUERY = true;
        driver().manage().window().maximize();
        openSite();
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }
}
