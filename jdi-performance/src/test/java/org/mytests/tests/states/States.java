package org.mytests.tests.states;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;
import org.mytests.uiobjects.example.entities.User;

import static org.mytests.uiobjects.example.site.SiteJdi.homePage;
import static org.mytests.uiobjects.example.site.SiteJdi.loginForm;
import static org.mytests.uiobjects.example.site.SiteJdi.logout;
import static org.mytests.uiobjects.example.site.SiteJdi.userIcon;
import static org.mytests.uiobjects.example.site.SiteJdi.userName;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */

@SuppressWarnings("PMD.ClassNamingConventions")
public class States {
    private static void onSite() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/"))
            homePage.open();
    }
    @Step
    public static void shouldBeLoggedIn() {
        onSite();
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
        onSite();
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
