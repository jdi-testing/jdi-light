package io.github.epam;

import io.github.com.DocsSite;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.DOMAIN;
import static com.epam.jdi.light.settings.WebSettings.logger;

public interface MultipleDomainsTestInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initSite(DocsSite.class);
        initSite(StaticSite.class);
        openUrl(DOMAIN);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}
