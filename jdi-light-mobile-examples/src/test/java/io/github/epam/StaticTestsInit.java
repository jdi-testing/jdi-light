package io.github.epam;

import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.mobile.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.mobile.elements.init.PageFactory.initElements;
import static com.epam.jdi.mobile.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;

public class StaticTestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initElements(StaticSite.class);
        homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
