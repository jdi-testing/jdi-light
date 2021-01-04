package org.jdiai.tests.jsdriver.states;

import org.jdiai.JS;

import static org.jdiai.tests.jsdriver.states.Pages.*;
import static org.jdiai.tools.JSTalk.*;

public class States {
    static JS userName = $("#user-name");
    static JS loginName = $("#name");
    static JS password = $("#password");
    static JS loginButton = $("#login-button");

    public static void logout() {
        driver().manage().deleteAllCookies();
    }
    public static void login() {
        userName.click();
        loginName.set("value='Roman'");
        password.set("value='Jdi1234'");
        loginButton.click();
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
