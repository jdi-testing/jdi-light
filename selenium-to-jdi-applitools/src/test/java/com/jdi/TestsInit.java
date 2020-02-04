package com.jdi;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.settings.WebSettings;
import jdisite.pages.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

import static com.epam.jdi.eyes.JDIEyes.*;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static jdisite.utils.DriverUtils.DRIVER;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSettings.init();
        WebDriverFactory.useDriver(DRIVER_NAME);
        DRIVER = WebDriverFactory.getDriver();
//        runChromeDriver();
        DRIVER.navigate().to(HomePage.URL);
        visualTestInitSelenium();
        logger.toLog("Run Tests");
    }

    @BeforeMethod
    public void before(Method method) {
        newVisualTest(method);
    }

    @AfterSuite (alwaysRun = true)
    public void tearDownSuite()
    {
        killAllSeleniumDrivers();
    }
}
