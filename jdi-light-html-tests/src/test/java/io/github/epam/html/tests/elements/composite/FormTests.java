package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.Header.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedOut;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static pseudo.site.PseudoSite.pseudoHeader;
import static pseudo.site.pages.Header.*;

public class FormTests extends TestsInit {

    @Test
    public void formInitializationTest() {
        SoftAssert softAssert = new SoftAssert();

        //1 Assert initialized elements are not null
        softAssert.assertNotNull(pseudoLoginFormLight);
        softAssert.assertNotNull(pseudoLoginForm);
        softAssert.assertNotNull(pseudoLoginFormSmart);
        softAssert.assertNotNull(pseudoLoginForm.userName);
        softAssert.assertNotNull(pseudoLoginForm.userPassword);
        softAssert.assertNotNull(pseudoLoginForm.loginButton);
        softAssert.assertNotNull(pseudoLoginFormSmart.userName);
        softAssert.assertNotNull(pseudoLoginFormSmart.userPassword);
        softAssert.assertNotNull(pseudoLoginFormSmart.loginButton);

        //2 Assert elements' locators are correct
        softAssert.assertEquals(pseudoLoginFormLight.locator.toString(), "");
        softAssert.assertEquals(pseudoLoginForm.locator.toString(), "");
        softAssert.assertEquals(pseudoLoginFormSmart.locator.toString(), "");
        softAssert.assertEquals(((HtmlElement) pseudoLoginForm.userName).locator.toString(), "css='#user-name'");
        softAssert.assertEquals(((HtmlElement) pseudoLoginForm.userPassword).locator.toString(), "css='#user-password'");
        softAssert.assertEquals(((HtmlElement) pseudoLoginForm.loginButton).locator.toString(), "css='#login-button'");

        //3 Assert elements' parents are correct
        softAssert.assertEquals(pseudoLoginFormLight.parent, pseudoHeader);
        softAssert.assertEquals(pseudoLoginForm.parent, pseudoHeader);
        softAssert.assertEquals(pseudoLoginFormSmart.parent, pseudoHeader);
        softAssert.assertEquals(((HtmlElement) pseudoLoginForm.userName).parent, pseudoLoginForm);
        softAssert.assertEquals(((HtmlElement) pseudoLoginForm.userPassword).parent, pseudoLoginForm);
        softAssert.assertEquals(((HtmlElement) pseudoLoginForm.loginButton).parent, pseudoLoginForm);
        softAssert.assertEquals(((HtmlElement) pseudoLoginFormSmart.userName).parent, pseudoLoginFormSmart);
        softAssert.assertEquals(((HtmlElement) pseudoLoginFormSmart.userPassword).parent, pseudoLoginFormSmart);
        softAssert.assertEquals(((HtmlElement) pseudoLoginFormSmart.loginButton).parent, pseudoLoginFormSmart);

        //4 Assert elements' names are correct
        softAssert.assertEquals(pseudoLoginFormLight.name, "Pseudo Login Form Light");
        softAssert.assertEquals(pseudoLoginForm.name, "Pseudo Login Form");
        softAssert.assertEquals(pseudoLoginFormSmart.name, "Pseudo Login Form Smart");
        softAssert.assertEquals(((HtmlElement) pseudoLoginForm.userName).name, "User Name");
        softAssert.assertEquals(((HtmlElement) pseudoLoginForm.userPassword).name, "User Password");
        softAssert.assertEquals(((HtmlElement) pseudoLoginForm.loginButton).name, "Login Button");
        softAssert.assertEquals(((HtmlElement) pseudoLoginFormSmart.userName).name, "User Name");
        softAssert.assertEquals(((HtmlElement) pseudoLoginFormSmart.userPassword).name, "User Password");
        softAssert.assertEquals(((HtmlElement) pseudoLoginFormSmart.loginButton).name, "Login Button");

        //5
        checkInitializedElement((JDIBase) pseudoLoginForm.getFindByWebElement(), "css='#some-id'", pseudoLoginForm, "Find By Web Element");

        //6
        checkInitializedElement((JDIBase) pseudoLoginForm.getFindByWebElementList(), "css='.some-list-class'", pseudoLoginForm, "Find By Web Element List");

        //7
        checkInitializedElement(pseudoLoginForm.getFindByUIElement(), "css='.some-class'", pseudoLoginForm, "Find By UI Element");

        softAssert.assertAll();
    }

    @Test
    public void loginWithUserTest() {
        shouldBeLoggedOut();
        loginForm.shouldBeOpened();
        loginForm.login(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginWithUserToSmartFormTest() {
        shouldBeLoggedOut();
        loginFormSmart.shouldBeOpened();
        loginFormSmart.login(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginWithUserToLightFormTest() {
        shouldBeLoggedOut();
        refresh();
        userIcon.click();
        loginFormLight.login(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginAsTest() {
        shouldBeLoggedOut();
        loginForm.shouldBeOpened();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void plainLoginTest() {
        shouldBeLoggedOut();
        loginForm.shouldBeOpened();
        loginForm.fill(DEFAULT_USER);
        loginForm.login();
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }


    @Test
    public void submitEntityToContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.submit(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void submitTextToContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.submit(defaultContactName);
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitEntityToContactFormUsingCustomButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.submit(DEFAULT_CONTACT, "custom");
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void submitEntityToContactFormUsingNonExistentButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        TIMEOUT.set(1);
        main.contactForm.submit(DEFAULT_CONTACT, "nonExistent");
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.submit(defaultContactName, "custom");
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void submitTextToContactFormUsingNonExistentButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        TIMEOUT.set(1);
        main.contactForm.submit(defaultContactName, "nonExistent");
    }

    @Test
    public void plainSubmitTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.submit();
        main.contactForm.check(DEFAULT_CONTACT);
    }

    private void checkInitializedElement(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        assertNotNull(htmlElementToCheck);
        assertEquals(htmlElementToCheck.locator.toString(), expectedLocator);
        assertEquals(htmlElementToCheck.parent, expectedParent);
        assertEquals(htmlElementToCheck.name, expectedName);
    }
}
