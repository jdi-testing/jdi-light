package io.github.epam.tests.epam.steps;

import com.epam.jdi.mobile.elements.composite.WebPage;
import io.qameta.allure.Step;

import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.Header.*;
import static io.github.epam.EpamGithubSite.header;
import static io.github.epam.entities.Users.DEFAULT_USER;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class Preconditions {
    @Step
    public static void shouldBeLoggedIn() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/"))
            homePage.open();
        if (!header.userName.isDisplayed())
            login();
    }
    @Step
    public static void login() {
        header.userIcon.click();
        header.loginForm.loginAs(DEFAULT_USER);
    }
    @Step
    public static void shouldBeLoggedOut() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/"))
            homePage.open();
        if (userName.isDisplayed())
            logout();
        if (loginForm.isDisplayed())
            userIcon.click();
    }
    @Step
    public static void logout() {
        if (!logout.isDisplayed())
            userIcon.click();
        logout.click();
    }
}
