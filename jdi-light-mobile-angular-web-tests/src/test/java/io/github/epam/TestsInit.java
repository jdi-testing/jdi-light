package io.github.epam;

import com.epam.jdi.light.mobile.AllurePropertiesGenerator;
import com.epam.jdi.light.mobile.settings.MobileSettings;
import io.github.com.StaticSite;
import io.github.epam.testng.TestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.logger;

@Listeners(TestNGListener.class)
public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        MobileSettings.init();
        killAllSeleniumDrivers();
        openSite(StaticSite.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        new AllurePropertiesGenerator().createAllureProperties();
        killAllSeleniumDrivers();
    }

    public boolean isFireFox() {
        return DRIVER.name.toLowerCase().equals("firefox");
    }
}