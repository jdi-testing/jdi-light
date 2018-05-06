package io.github.epam;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.jdi.light.settings.WebSettings;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class SimpleTestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSettings.init();
        logger.setLogLevel(STEP);
        PageFactory.initElements(EpamGithubSite.class);
        EpamGithubSite.homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        WebDriverFactory.close();
    }
}
