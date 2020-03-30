package io.github.epam.steps;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;

import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static io.github.epam.StaticSite.homePage;
import static io.github.epam.entities.Users.DEFAULT_USER;
import static io.github.epam.sections.Header.*;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class Preconditions {
    @Step
    public static void shouldBeLoggedIn() {
        if (!WebPage.getUrl().contains(DRIVER.domain))
            homePage.open();
        if (!userName.isDisplayed())
            login();
    }
    @Step
    public static void login() {
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
    }
    @Step
    public static void shouldBeLoggedOut() {
        if (!WebPage.getUrl().contains(DRIVER.domain))
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
