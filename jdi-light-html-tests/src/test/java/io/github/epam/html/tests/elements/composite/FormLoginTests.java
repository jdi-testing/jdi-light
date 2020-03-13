package io.github.epam.html.tests.elements.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static io.github.com.StaticSite.*;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.Header.*;
import static io.github.epam.html.tests.site.steps.States.*;

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
