package org.mytests.tests.states;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;
import org.mytests.uiobjects.example.entities.User;

import static org.mytests.uiobjects.example.site.SiteJdi.*;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class States {
    @Step
    public static void shouldBeLoggedIn() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/"))
            homePage.open();
        if (!userName.isDisplayed())
            login();
    }
    @Step
    public static void login() {
        userIcon.click();
        loginForm.submit(new User(), "enter");
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
