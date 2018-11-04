package io.github.epam;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.epam.EpamGithubSite.homePage;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {

        logger.setLogLevel(STEP);
        initElements(EpamGithubSite.class);
        homePage.open();
        logger.toLog("Run Tests");

    }
    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        WebDriverFactory.close();
    }
}
