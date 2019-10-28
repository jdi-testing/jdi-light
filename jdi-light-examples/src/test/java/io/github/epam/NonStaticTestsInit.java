package io.github.epam;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.jdi.light.settings.WebSettings;
import io.github.com.NonStaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NonStaticTestsInit {

    @BeforeSuite
    public void setUp() {

        PageFactory.initElements(NonStaticSite.class);
        new NonStaticSite().getHomePage().open();
        WebSettings.logger.toLog("Run tests");
    }

    @Test
    public void test() {}

    @AfterSuite
    public void cleanUp() {

        WebDriverUtils.killAllSeleniumDrivers();
    }
}
