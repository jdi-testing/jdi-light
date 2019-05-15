package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.FormDataProvider;

import static com.epam.jdi.light.common.FormFilters.ALL;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.Header.*;
import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedOut;
import static org.testng.Assert.assertEquals;
import static pseudo.site.PseudoSite.pseudoHeader;
import static pseudo.site.pages.Header.pseudoFormLight;

public class FormTests extends TestsInit {

    @Test(dataProvider = "formDataProvider", dataProviderClass = FormDataProvider.class)
    public void formInitializationTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "smartFormDataProvider", dataProviderClass = FormDataProvider.class)
    public void smartFormInitializationTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test
    public void lightFormInitializationTest() {
        checkInitializedElement(pseudoFormLight, "", pseudoHeader, "Pseudo Form Light");
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
        main.contactForm.submit(defaultName);
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
        main.contactForm.submit(defaultName, "custom");
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void submitTextToContactFormUsingNonExistentButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        TIMEOUT.set(1);
        main.contactForm.submit(defaultName, "nonExistent");
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

    @Test
    public void pressButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.pressButton("custom");
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void sendTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.send();
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void sendEntityTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.send(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void addEntityTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.add(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void publishTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.publish(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void saveTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.save(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void updateTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.update(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void cancelTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.cancel(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void closeTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.close(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void backTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.back(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void selectTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.select(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void nextTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.next(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void searchTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.search(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void onlyMandatoryTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.onlyMandatory().fill(DEFAULT_CONTACT);
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactForm.getFilter(), ALL);
    }

    @Test
    public void onlyOptionalTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.onlyOptional().fill(DEFAULT_CONTACT);
        main.contactForm.check(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactForm.getFilter(), ALL);
    }
}
