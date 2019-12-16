package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.settings.WebSettings;
import com.sun.deploy.security.WSecureRandom;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;

public class BrowserOpen  {

    @Test
    public void before() {
        WebSettings.init();
        WebDriverFactory.getDriver();
        WebDriverUtils.killAllSeleniumDrivers();
    }

}
