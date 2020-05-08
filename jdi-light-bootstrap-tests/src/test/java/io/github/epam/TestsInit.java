package io.github.epam;

import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.getWebSettings;

@SuppressWarnings("PMD.ClassNamingConventions")
public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        openSite(StaticSite.class);
        getWebSettings().logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}
