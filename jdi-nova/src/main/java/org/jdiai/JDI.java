package org.jdiai;

import com.epam.jdi.tools.Safe;
import org.jdiai.jswraper.DriverManager;
import org.jdiai.jswraper.JSSmart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.jdiai.jswraper.JSWrappersUtils.NAME_TO_LOCATOR;
import static org.jdiai.jswraper.JSWrappersUtils.locatorsToBy;

public class JDI {
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
        if (driver().getCurrentUrl().equals("data:,")) {
            openPage(DOMAIN);
        }
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
        return new JS(JDI::driver, locator);
    }
    public static JS $(By... locators) {
        return new JS(JDI::driver, locators);
    }
    public static JS $(String locator) {
        return new JS(JDI::driver, NAME_TO_LOCATOR.execute(locator));
    }
    public static JS $(String... locators) {
        return new JS(JDI::driver, locatorsToBy(locators));
    }
    public static void loginAs(String formLocator, Object user) {
        $(formLocator).loginAs(user);
    }
    public static void loginAs(Object user) {
        new JS(JDI::driver).loginAs(user);
    }
    public static void submitForm(String formLocator, Object user) {
        $(formLocator).submit(user);
    }
    public static void submitForm(Object user) {
        new JS(JDI::driver).submit(user);
    }
    public static void fillFormWith(String formLocator, Object user) {
        $(formLocator).fill(user);
    }
    public static void fillFormWith(Object user) {
        new JS(JDI::driver).fill(user);
    }
    public static DragAndDrop drag(JS dragElement) { return new DragAndDrop(dragElement);}

    public static JSSmart jsDriver() { return new JSSmart(JDI::driver); }
}
