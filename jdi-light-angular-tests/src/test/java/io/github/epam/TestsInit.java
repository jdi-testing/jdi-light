package io.github.epam;

import io.github.com.StaticSite;
import io.github.epam.testng.TestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.JDISettings.getJDISettings;
import static com.epam.jdi.light.settings.WebSettings.getWebSettings;

@Listeners(TestNGListener.class)
public class TestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        killAllSeleniumDrivers();
        initSite(StaticSite.class);
        openUrl(getJDISettings().DRIVER.domain);
        getWebSettings().logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }

    protected static boolean isFireFox() {
        return getJDISettings().DRIVER.name.equalsIgnoreCase("firefox");
    }
}
