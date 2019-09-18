package io.github.epam.tests.selenium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.site.SiteJdi;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;

public interface SimpleTestsInit {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initElements(SiteJdi.class);
        logger.info("Run Tests");
    }


    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
