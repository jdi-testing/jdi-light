package io.github.epam;

import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.jdi.tools.logger.LogLevels;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.logger.LogLevels.*;

public class SimpleTestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        logger.setLogLevel(STEP);
        PageFactory.initElements(EpamGithubSite.class);
        EpamGithubSite.homePage.open();
        logger.info("Run Tests");
    }

}
