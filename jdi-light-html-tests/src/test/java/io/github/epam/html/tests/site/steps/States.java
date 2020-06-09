package io.github.epam.html.tests.site.steps;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;

import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.*;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class States {
    @Step
    public static void shouldBeLoggedIn() {
        String url = WebPage.getUrl();
        if (!url.contains("https://jdi-testing.github.io/jdi-light/") || epamLogo.isNotExist())
            homePage.open();
        if (userName.isHidden())
            login();
    }

    @Step
    public static void login() {
        loginForm.isDisplayed();
        if (loginForm.isHidden())
            userIcon.click();
        loginForm.submit(DEFAULT_USER);
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
