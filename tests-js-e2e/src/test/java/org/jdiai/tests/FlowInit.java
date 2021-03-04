package org.jdiai.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.Runtime.getRuntime;
import static org.jdiai.jsbuilder.JSBuilder.LOG_QUERY;
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

    default void killDrivers() {
        try {
            getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignore) { }
    }
}
