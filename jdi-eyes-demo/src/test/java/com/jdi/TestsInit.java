package com.jdi;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import jdisite.pages.JDISite;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static com.epam.jdi.eyes.JDIEyes.*;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        openSite(JDISite.class);
        visualTestInitJdi();
    }

    @BeforeMethod
    public void before(Method method) {
        newVisualTest(method);
    }

    @AfterSuite(alwaysRun = true)
    public static void teardown() {
        closeAllEyes();
        killAllSeleniumDrivers();
    }
}
