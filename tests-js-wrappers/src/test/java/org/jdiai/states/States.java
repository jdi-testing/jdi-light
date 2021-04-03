package org.jdiai.states;

import org.openqa.selenium.Cookie;

import static org.jdiai.Pages.*;
import static org.jdiai.jswraper.JSWrapper.driver;

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
        if (!isLoggedIn()) {
            login();
        }
        openPage(url);
    }
    public static boolean isLoggedIn() {
        openSite();
        return driver().manage().getCookieNamed("authUser") != null;
    }

}
