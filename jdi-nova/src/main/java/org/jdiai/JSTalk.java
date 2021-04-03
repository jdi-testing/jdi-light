package org.jdiai;

import com.epam.jdi.tools.Safe;
import org.jdiai.jswraper.DriverManager;
import org.jdiai.jswraper.JSSmart;
import org.jdiai.jswraper.JSWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.jdiai.jswraper.JSWrappersUtils.defineLocator;
import static org.jdiai.jswraper.JSWrappersUtils.locatorsToBy;

public class JSTalk {
    public static Safe<WebDriver> DRIVER = new Safe<>(DriverManager::chromeDriver);
    public static String DOMAIN;

    public static WebDriver driver() {
        return DRIVER.get();
    }
    public static void openSite(String url) {
        DOMAIN = url;
        openSite();
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
    public static JS $(By locator) {
        return new JS(JSTalk::driver, locator);
    }
    public static JS $(By... locators) {
        return new JS(JSTalk::driver, locators);
    }
    public static JS $(String locator) {
        return new JS(JSTalk::driver, defineLocator(locator));
    }
    public static JS $(String... locators) {
        return new JS(JSTalk::driver, locatorsToBy(locators));
    }
    public static void loginAs(String formLocator, Object user) {
        $(formLocator).loginAs(user);
    }
    public static void loginAs(Object user) {
        new JS(JSTalk::driver).loginAs(user);
    }
    public static void submitForm(String formLocator, Object user) {
        $(formLocator).submit(user);
    }
    public static void submitForm(Object user) {
        new JS(JSTalk::driver).submit(user);
    }
    public static void fillForm(String formLocator, Object user) {
        $(formLocator).fill(user);
    }
    public static void fillForm(Object user) {
        new JS(JSTalk::driver).fill(user);
    }

    public static JSSmart jsDriver() { return new JSSmart(JSTalk::driver); }
}
