package io.github.epam.tests.selenium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.site.SiteJdi;

import static com.epam.jdi.mobile.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.mobile.elements.init.PageFactory.initElements;
import static com.epam.jdi.mobile.settings.WebSettings.logger;

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
