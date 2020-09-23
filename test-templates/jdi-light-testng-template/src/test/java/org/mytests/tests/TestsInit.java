package org.mytests.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.mytests.tests.testng.TestNGListener;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

@Listeners(TestNGListener.class)
public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        killAllSeleniumDrivers();
        final WebDriver[] dr = new WebDriver[2];
        Thread tr1 = new Thread(() -> {
            dr[0] = WebDriverFactory.getDriver();
        });
        tr1.start();
        while (tr1.isAlive()) { }
        Thread tr2 = new Thread(() -> {
            dr[1] = WebDriverFactory.getDriver();
        });
        tr2.start();
        while (tr2.isAlive()) { }
        openSite(SiteJdi.class);
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
