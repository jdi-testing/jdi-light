package io.github.epam;


import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.DOMAIN;
import static com.epam.jdi.light.settings.WebSettings.logger;

import com.epam.jdi.light.settings.WebSettings;
import io.github.com.StaticSite;
import io.github.epam.testng.TestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


@SuppressWarnings("PMD.ClassNamingConventions")
@Listeners(TestNGListener.class)
public class TestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSettings.init();
        killAllSeleniumDrivers();
        initSite(StaticSite.class);
        openUrl(DOMAIN);
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
