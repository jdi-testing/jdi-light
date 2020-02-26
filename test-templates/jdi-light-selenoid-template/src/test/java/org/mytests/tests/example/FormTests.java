package org.mytests.tests.example;

import org.mytests.tests.TestsInit;
import org.mytests.tests.preconditions.Preconditions;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_CONTACT;
import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_USER;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.mytests.uiobjects.example.site.pages.ContactFormPage.contactForm;

public class FormTests extends TestsInit {

    @Test
    public void loginTest() {
        Preconditions.shouldBeLoggedOut();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        Preconditions.shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        contactForm.submit(DEFAULT_CONTACT);
        contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void fillContactsTest() {
        Preconditions.shouldBeLoggedIn();
        contactsPage.shouldBeOpened();
        contactsPage.asForm().submit(DEFAULT_CONTACT);
        contactsPage.asForm().check(DEFAULT_CONTACT);
    }
}
