package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

@SuppressWarnings("PMD.ClassNamingConventions")
public class Cookies {

    private static WebDriver.Options manage() { return WebDriverFactory.getDriver().manage(); }
    /**
     * Get all browser cookies
     * @return Set
     */
    @JDIAction("Get site cookies")
    public static Set<Cookie> getCookies() {
        return manage().getCookies();
    }
    /**
     * Get cookie by name
     * @param value Get cookie by name
     */
    @JDIAction("Get cookie '{0}'")
    public static Cookie getCookie(String value) {
        return manage().getCookieNamed(value);
    }
    /**
     * @param cookie Specify cookie
     *               Add cookie in browser
     */
    @JDIAction("Add cookie '{0}'")
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
