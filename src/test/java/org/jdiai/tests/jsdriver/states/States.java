package org.jdiai.tests.jsdriver.states;

import org.openqa.selenium.Cookie;

import static org.jdiai.tests.jsdriver.states.Pages.HOME_PAGE;
import static org.jdiai.tests.jsdriver.states.Pages.PERFORMANCE_PAGE;
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
    public static void loggedInAt(String url) {
        if (!isLoggedIn())
            login();
        openPage(url);
    }
    public static boolean isLoggedIn() {
        return driver().manage().getCookieNamed("authUser") != null;
    }

    public static void atPerformancePage() {
        if (!isLoggedIn())
            login();
        openPage(PERFORMANCE_PAGE);
    }
}
