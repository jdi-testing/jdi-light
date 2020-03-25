package io.github.epam.tests.selenium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.site.SiteJdi;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.settings.WebSettings.*;

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
