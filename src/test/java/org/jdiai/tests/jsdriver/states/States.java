package org.jdiai.tests.jsdriver.states;

import org.openqa.selenium.Cookie;

import static org.jdiai.tests.jsdriver.states.Pages.*;
import static org.jdiai.tools.JSTalk.driver;
import static org.jdiai.tools.JSTalk.openPage;

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
    public static boolean isLoggedIn() {
        return driver().manage().getCookieNamed("authUser") != null;
    }
    public static void atSimplePage() {
        if (!isLoggedIn())
            login();
        openPage(SIMPLE_PAGE);
    }
    public static void atUsersPage() {
        if (!isLoggedIn())
            login();
        openPage(USERS_PAGE);
    }
}
