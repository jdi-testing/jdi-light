package com.jditest.states;

import org.openqa.selenium.Cookie;

import static com.jditest.DriverManager.driver;
import static com.jditest.Pages.*;

public class States {

    public static void logout() {
        openSite();
        driver().manage().deleteAllCookies();
        driver().navigate().refresh();
    }
    public static void login() {
        openSite();
        driver().manage().addCookie(new Cookie("authUser", "true"));
        driver().navigate().refresh();
    }
    public static void atHomePage() {
        openPage(HOME_PAGE);
    }
    public static void loggedInAt(String url) {
        if (!isLoggedIn())
            login();
        openPage(url);
    }
    public static boolean isLoggedIn() {
        openSite();
        return driver().manage().getCookieNamed("authUser") != null;
    }

}
