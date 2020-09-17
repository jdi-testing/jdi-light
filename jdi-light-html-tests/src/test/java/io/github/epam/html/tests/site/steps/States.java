package io.github.epam.html.tests.site.steps;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;

import static com.epam.jdi.light.elements.composite.WebPage.verifyUrl;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.*;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class States {
    @Step
    public static void shouldBeLoggedIn() {
        moveToHomePage();
        if (userName.isHidden())
            login();
    }
    @Step
    public static void moveToHomePage() {
        if (!verifyUrl("https://jdi-testing.github.io/jdi-light/") || epamLogo.isNotExist())
            homePage.open();
    }

    @Step
    public static void login() {
        if (loginForm.isHidden())
            userIcon.click();
        loginForm.is().displayed();
        loginForm.submit(DEFAULT_USER);
        userName.has().text("ROMAN IOVLEV");
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
