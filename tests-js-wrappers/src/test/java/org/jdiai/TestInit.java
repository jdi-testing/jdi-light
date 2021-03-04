package org.jdiai;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.jdiai.DriverManager.initDriver;
import static org.jdiai.DriverManager.killDrivers;
import static org.jdiai.Pages.openSite;
import static org.jdiai.jsbuilder.JSBuilder.LOG_QUERY;

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
        initDriver();
        openSite();
        LOG_QUERY = true;
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }

}
