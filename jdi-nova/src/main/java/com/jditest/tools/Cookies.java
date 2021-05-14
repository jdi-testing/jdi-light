package com.jditest.tools;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Collection;
import java.util.Set;

import static com.jditest.JDI.driver;

/**
 * Created by Roman Iovlev on 06.05.2021
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Cookies {

    private static WebDriver.Options manage() {
        return driver().manage();
    }
    /**
     * Get all browser cookies
     * @return Set
     */
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
    public static Cookie getCookie(String name) {
        return manage().getCookieNamed(name);
    }
    /**
     * @param cookie Specify cookie
     *               Add cookie in browser
     */
    public static void addCookie(Cookie cookie) {
        manage().addCookie(cookie);
    }
    /**
     * @param cookies Specify collection of the cookies
     *               Add cookies in browser
     */
    public static void addCookies(Collection<Cookie> cookies) {
        if (cookies == null)
            return;
        for (Cookie cookie : cookies)
            addCookie(cookie);
    }    /**
     * @param cookies Specify collection of the cookies
     *               Add cookies in browser
     */
    public static void setCookies(Collection<Cookie> cookies) {
        clearAllCookies();
        addCookies(cookies);
    }
    /**
     * Clear browsers cache
     */
    public static void clearAllCookies() {
        manage().deleteAllCookies();
    }
    /**
     * Clear browsers cache
     */
    public static void deleteCookie(Cookie cookie) {
        manage().deleteCookie(cookie);
    }
    /**
     * Clear browsers cache
     */
    public static void deleteCookie(String name) {
        manage().deleteCookieNamed(name);
    }
}
