package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.settings.WebSettings;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class BrowserOpen {

    @Test
    public void before() {
        WebSettings.init();
        WebDriverFactory.getDriver();
        WebDriverUtils.killAllSeleniumDrivers();
        logger.info("!!! TEST HAS PASSED");
    }

}
