package io.github.epam.parallel;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.entities.User;
import io.qameta.allure.Step;

import static io.github.epam.EpamGithubSite.header;
import static io.github.epam.EpamGithubSite.homePage;
import static io.github.epam.entities.Users.DEFAULT_USER;

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
        login(DEFAULT_USER);
    }

    @Step
    public static void login(User user) {
        if (!header.userName.isDisplayed()) {
            header.userIcon.click();
            header.loginForm.loginAs(user);
        }
    }

    @Step
    public static void shouldBeLoggedOut() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/"))
            homePage.open();
        if (header.userName.isDisplayed())
            logout();
        if (header.loginForm.isDisplayed())
            header.userIcon.click();
    }

    @Step
    public static void logout() {
        if (!header.logout.isDisplayed())
            header.userIcon.click();
        header.logout.click();
    }
}
