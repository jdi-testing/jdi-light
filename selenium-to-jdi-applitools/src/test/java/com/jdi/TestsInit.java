package com.jdi;

import jdisite.pages.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.epam.jdi.eyes.JDIEyes.*;
import static com.epam.jdi.light.common.VisualCheckAction.IS_DISPLAYED;
import static com.epam.jdi.light.common.VisualCheckAction.ON_VISUAL_ACTION;
import static com.epam.jdi.light.common.VisualCheckPage.CHECK_NEW_PAGE;
import static java.lang.Runtime.getRuntime;
import static jdisite.utils.DriverUtils.DRIVER;
import static jdisite.utils.DriverUtils.runChromeDriver;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        runChromeDriver();
        DRIVER.navigate().to(HomePage.URL);
        visualTestInit(CHECK_NEW_PAGE, IS_DISPLAYED);
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
