package org.jdiai.tools;

import com.epam.jdi.tools.Safe;
import org.jdiai.jswraper.JSSmart;
import org.jdiai.jswraper.JSWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.jdiai.jswraper.JSWrappersUtils.defineLocator;
import static org.jdiai.jswraper.JSWrappersUtils.locatorsToBy;

public class JSTalk {
    public static Safe<WebDriver> DRIVER = new Safe<>(JSWrapper::chromeDriver);
    public static String DOMAIN;

    public static WebDriver driver() {
        return DRIVER.get();
    }
    public static void openSite() {
        openPage(DOMAIN);
    }
    public static void openPage(String url) {
        if (isEmpty(DOMAIN) || url.contains("//")) {
            driver().get(url);
        }
        else {
            driver().get(DOMAIN + url);
        }
    }
    public static JS $(By... locators) {
        return new JS(driver(), locators);
    }
    public static JS $(String locator) {
        return new JS(driver(), defineLocator(locator));
    }
    public static JS $(String... locators) {
        return new JS(driver(), locatorsToBy(locators));
    }
    public static JSSmart jsDriver() { return new JSSmart(driver()); }
}
