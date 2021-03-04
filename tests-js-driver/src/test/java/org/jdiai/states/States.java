package org.jdiai.states;

import org.openqa.selenium.Cookie;

import static org.jdiai.DriverManager.driver;
import static org.jdiai.Pages.HOME_PAGE;
import static org.jdiai.Pages.openPage;

public class States {

    public static void logout() {
        driver().manage().deleteAllCookies();
        driver().navigate().refresh();
    }
    public static void login() {
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
        return driver().manage().getCookieNamed("authUser") != null;
    }

}
