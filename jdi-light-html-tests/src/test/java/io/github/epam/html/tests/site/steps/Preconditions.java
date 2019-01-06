package io.github.epam.html.tests.site.steps;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;

import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.*;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class Preconditions {
    @Step
    public static void shouldBeLoggedIn() {
        if (!WebPage.getUrl().contains("https://epam.github.io/JDI/"))
            homePage.open();
        if (userName.isHidden())
            login();
    }
    @Step
    public static void login() {
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
    }
    @Step
    public static void shouldBeLoggedOut() {
        System.out.println("THREAD ID" + Thread.currentThread().getId());
        if (userName.isDisplayed())
            logout();
    }
    @Step
    public static void logout() {
        userIcon.click();
        logout.click();
    }
}
