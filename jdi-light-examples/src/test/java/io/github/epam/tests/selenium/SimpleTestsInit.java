package io.github.epam.tests.selenium;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import selenium.site.SiteJdi;

import static com.epam.jdi.light.actions.ActionHelper.ERROR_THROWN;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class SimpleTestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        logger.setLogLevel(STEP);
        initElements(SiteJdi.class);
        logger.info("Run Tests");
    }

    @BeforeMethod
    public void before() {
        ERROR_THROWN = false;
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        WebDriverFactory.close();
    }
}
