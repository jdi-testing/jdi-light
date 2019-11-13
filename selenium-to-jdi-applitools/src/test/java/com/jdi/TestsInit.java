package com.jdi;

import jdisite.pages.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.epam.jdi.eyes.JDIEyes.*;
import static java.lang.Runtime.getRuntime;
import static jdisite.utils.DriverUtils.DRIVER;
import static jdisite.utils.DriverUtils.runChromeDriver;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        runChromeDriver();
        DRIVER.navigate().to(HomePage.URL);
        visualTestInitSelenium();
    }

    @BeforeMethod
    public void before(Method method) {
        newVisualTest(method);
    }

    @AfterSuite(alwaysRun = true)
    public static void teardown() throws IOException {
        closeAllEyes();
        getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
}
