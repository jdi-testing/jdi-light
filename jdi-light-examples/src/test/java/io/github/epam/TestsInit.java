package io.github.epam;

import io.github.epam.testng.TestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.epam.EpamGithubSite.homePage;

public class TestsInit extends TestNGListener {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initElements(EpamGithubSite.class);
        homePage.open();
        logger.toLog("Run Tests");

    }
    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
