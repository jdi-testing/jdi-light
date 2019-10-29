package org.mytests.tests;

import org.mytests.uiobjects.example.site.SiteJdi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

import static com.epam.jdi.eyes.JDIEyes.*;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.String.format;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initSite(SiteJdi.class);
        initVisualTest("J9WC7iD104muzDaL6osEneluBJhfwRBA97e99YofWV5Rptw110");
        homePage.open();
        homePage.checkOpened();
        logger.info("Run Tests");
    }
    @BeforeMethod
    public void before(Method method) {
        newVisualTest(format("%s.%s", method.getDeclaringClass().getSimpleName(), method.getName()));
    }
    @AfterSuite(alwaysRun = true)
    public void teardown() {
        closeAllEyes();
        killAllSeleniumDrivers();
    }
}
