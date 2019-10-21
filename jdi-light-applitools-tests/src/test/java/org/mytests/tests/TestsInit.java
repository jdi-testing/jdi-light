package org.mytests.tests;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.epam.jdi.eyes.EyesConfig;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

import static com.epam.jdi.eyes.JDIEyes.*;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.String.format;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initSite(SiteJdi.class);
        //EyesRunner runner = new ClassicRunner();
        //Eyes eyes = new Eyes();
        //eyes.setApiKey("J9WC7iD104muzDaL6osEneluBJhfwRBA97e99YofWV5Rptw110");
        //eyes.open(getDriver(), "JDI Application", "Smoke Test");

        initVisualTest(new EyesConfig().set(c -> c.apiKey = "J9WC7iD104muzDaL6osEneluBJhfwRBA97e99YofWV5Rptw110"));
        homePage.open();
        logger.info("Run Tests");
    }
    @BeforeMethod
    public void before(Method method) {
        startVisualTest(format("%s.%s", method.getDeclaringClass().getSimpleName(), method.getName()));
    }

    @AfterMethod
    public void after(Method method) {
        endVisualTest();
    }
    @AfterSuite(alwaysRun = true)
    public void teardown() {
        killAllSeleniumDrivers();
    }
}
