package io.github.epam;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.settings.JDISettings.PAGE;
import static com.epam.jdi.light.settings.WebSettings.logger;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        PAGE.beforeNewPage = page -> {
            WebPage.beforeNewPage(page);
            $("//*[@id='loaавыаывding-bar-spinner']").waitFor(10).displayed();
        };
        openSite(StaticSite.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}
