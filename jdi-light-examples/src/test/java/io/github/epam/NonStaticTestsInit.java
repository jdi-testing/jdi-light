package io.github.epam;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.jdi.light.settings.WebSettings;
import io.github.com.NonStaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class NonStaticTestsInit {

    protected NonStaticSite nonStaticSite;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {

        nonStaticSite = new NonStaticSite();
        PageFactory.initElements(nonStaticSite);

        nonStaticSite.getHomePage().open();
        WebSettings.logger.toLog("Non Static site page opened");
    }


    @AfterSuite(alwaysRun = true)
    public void cleanUp() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
