package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.FormDataProvider;

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
import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class FormTests extends TestsInit {

    @Test(dataProvider = "formDataProvider", dataProviderClass = FormDataProvider.class)
    public void formInitializationTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
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
}
