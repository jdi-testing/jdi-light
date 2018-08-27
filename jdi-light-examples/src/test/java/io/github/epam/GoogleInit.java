package io.github.epam;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import com.google.GoogleSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.composite.WebPage.CHECK_AFTER_OPEN;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class GoogleInit  {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        logger.setLogLevel(INFO);
        PageFactory.initElements(GoogleSite.class);
        CHECK_AFTER_OPEN = true;
        GoogleSite.homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        WebDriverFactory.close();
    }
}
