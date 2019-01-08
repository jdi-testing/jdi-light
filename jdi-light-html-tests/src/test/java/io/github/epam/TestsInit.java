package io.github.epam;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH_LOCATORS;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static io.github.com.StaticSite.homePage;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        //logger.setLogLevel(STEP);
        SMART_SEARCH_LOCATORS.add("[ui=%s]");
        initElements(StaticSite.class);
        homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        WebDriverFactory.close();
    }
}
