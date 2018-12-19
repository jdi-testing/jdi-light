package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Cookies {

    private static WebDriver.Options manage() { return WebDriverFactory.getDriver().manage(); }
    /**
     *   Get all browser cookies
     */
    @JDIAction
    public static Set<Cookie> getCookies() {
        return manage().getCookies();
    }
    /**
     * @param name Get cookie by nam
     */
    @JDIAction
    public static Cookie getCookie(String name) {
        return manage().getCookieNamed(name);
    }
    /**
     * @param cookie Specify cookie
     *               Add cookie in browser
     */
    @JDIAction
    public static void addCookie(Cookie cookie) {
        manage().addCookie(cookie);
    }

    /**
     * Clear browsers cache
     */
    @JDIAction("Delete all cookies")
    public static void clearAllCookies() {
        manage().deleteAllCookies();
    }
}
