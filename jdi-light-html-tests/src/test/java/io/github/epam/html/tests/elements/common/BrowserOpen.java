package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.settings.WebSettings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BrowserOpen {

    private WebDriver driver;

    @Test
    public void before() {
        WebSettings.init();
        WebDriverFactory.getDriver();
        WebDriverUtils.killAllSeleniumDrivers();

    }

}
