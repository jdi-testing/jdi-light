package org.mytests.tests.example;

import com.epam.jdi.light.elements.composite.Form;
import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.states.States;
import org.mytests.uiobjects.example.entities.Contacts;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static org.mytests.tests.states.States.*;
import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_CONTACT;
import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_USER;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.mytests.uiobjects.example.site.pages.ContactFormPage.contactForm;

public class FormTests extends SimpleTestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        contactForm.submit(DEFAULT_CONTACT);
        contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void fillContactsTest() {
        shouldBeLoggedIn();
        contactsPage.shouldBeOpened();
        Form<Contacts> contactFrom = contactsPage.asForm();
        contactFrom.submit(DEFAULT_CONTACT);
        contactFrom.check(DEFAULT_CONTACT);
    }
}
