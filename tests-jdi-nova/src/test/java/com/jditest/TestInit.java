package com.jditest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.jditest.JDI.DOMAIN;
import static com.jditest.jsbuilder.QueryLogger.ALL;
import static com.jditest.jsbuilder.QueryLogger.LOG_QUERY;
import static com.jditest.jswraper.DriverManager.CHROME_OPTIONS;
import static com.jditest.jswraper.DriverManager.killDrivers;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        CHROME_OPTIONS = cap -> cap.addArguments("--headless");
        LOG_QUERY = ALL;
        DOMAIN = "https://jdi-testing.github.io/jdi-light";
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }

}
