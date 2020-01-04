package io.github.epam;

import io.github.com.StaticSite;
import io.github.com.sections.modal.SectionModalLongScrolling;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.DOMAIN;
import static com.epam.jdi.light.settings.WebSettings.logger;

@SuppressWarnings("PMD.ClassNamingConventions")
public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
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
