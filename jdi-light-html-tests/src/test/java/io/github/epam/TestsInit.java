package io.github.epam;

import com.epam.jdi.light.ui.html.HtmlSettings;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pseudo.site.PseudoSiteUtils;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        HtmlSettings.init();
        initSite(StaticSite.class);
        initSite(PseudoSiteUtils.class);
        homePage.open();
        logger.toLog("Run Tests");
    }


    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }

    protected static boolean isFireFox() {
        return DRIVER_NAME.equalsIgnoreCase("firefox");
    }
}
