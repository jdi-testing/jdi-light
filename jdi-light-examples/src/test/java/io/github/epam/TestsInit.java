package io.github.epam;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.epam.EpamGithubSite.homePage;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestsInit {

    @BeforeMethod

    //  @BeforeSuite(alwaysRun = true)
    public static void setUp() {

        logger.setLogLevel(STEP);
        initElements(EpamGithubSite.class);
        homePage.open();
        logger.toLog("Run Tests");

    }

    @AfterMethod(alwaysRun = true)

    //   @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        WebDriverFactory.close();
    }
}
