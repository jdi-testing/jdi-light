package io.github.epam.html.tests.elements.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.elements.init.UIFactory.loginAs;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedOut;

public class FormLoginTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedOut();
        refresh();
    }

    @Test
    public void loginWithUserTest() {
        loginForm.shouldBeOpened();
        loginForm.login(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginWithUserToSmartFormTest() {
        loginFormSmart.shouldBeOpened();
        loginFormSmart.login(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginWithUserToLightFormTest() {
        userIcon.click();
        loginFormLight.login(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginWithUserToLightLocatorFormTest() {
        userIcon.click();
        //loginFormLightLocator.login(DEFAULT_USER);
        //form("#login-form", User.class).login(DEFAULT_USER);
        loginAs("#login-form", DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginAsUserTest() {
        loginForm.shouldBeOpened();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void plainLoginTest() {
        loginForm.shouldBeOpened();
        loginForm.fill(DEFAULT_USER);
        loginForm.login();
        homePage.checkOpened();
    }
}
