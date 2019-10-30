package io.github.epam;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.jdi.light.settings.WebSettings;
import io.github.com.NonStaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.site.NonStaticSiteJdi;

public class NonStaticTestsInit {

    @BeforeSuite
    public void setUp() {

        NonStaticSite nonStaticSite = new NonStaticSite();
        NonStaticSiteJdi nonStaticSiteJdi = new NonStaticSiteJdi();
        PageFactory.initElements(nonStaticSite, nonStaticSiteJdi);

        EpamGithubNonStaticSite epamGithubNonStaticSite = new EpamGithubNonStaticSite();
        PageFactory.initElements(epamGithubNonStaticSite);

        nonStaticSite.getHomePage().open();
        WebSettings.logger.toLog("Non Static site page opened");

        nonStaticSiteJdi.getHomePage().open();
        WebSettings.logger.toLog("Non Static site JDI page opened");

        epamGithubNonStaticSite.getHomePage().open();
        WebSettings.logger.toLog("Epam Github Non Static site page opened");
    }

    @AfterSuite
    public void cleanUp() {

        WebDriverUtils.killAllSeleniumDrivers();
    }
}
