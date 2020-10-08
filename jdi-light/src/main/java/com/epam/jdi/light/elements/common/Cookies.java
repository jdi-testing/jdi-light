package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
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

    public static boolean hasCookie(String name) {
        return getCookie(name) != null;
    }
    public static boolean hasNoCookie(String name) {
        return getCookie(name) == null;
    }
    /**
     * Get cookie by name
     * @param name Get cookie by name
     */
    @JDIAction("Get cookie '{0}'")
    public static Cookie getCookie(String name) {
        return manage().getCookieNamed(name);
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
     * @param cookies Specify collection of the cookies
     *               Add cookies in browser
     */
    @JDIAction("Add cookie '{0}'")
    public static void addCookies(Collection<Cookie> cookies) {
        if (cookies == null)
            return;
        for (Cookie cookie : cookies)
            addCookie(cookie);
    }    /**
     * @param cookies Specify collection of the cookies
     *               Add cookies in browser
     */
    @JDIAction("Add cookie '{0}'")
    public static void setCookies(Collection<Cookie> cookies) {
        clearAllCookies();
        addCookies(cookies);
    }
    /**
     * Clear browsers cache
     */
    @JDIAction("Delete all cookies")
    public static void clearAllCookies() {
        manage().deleteAllCookies();
    }
    /**
     * Clear browsers cache
     */
    @JDIAction("Delete all cookies")
    public static void deleteCookie(Cookie cookie) {
        manage().deleteCookie(cookie);
    }
    /**
     * Clear browsers cache
     */
    @JDIAction("Delete all cookies")
    public static void deleteCookie(String name) {
        manage().deleteCookieNamed(name);
    }
}
