package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.preconditions.Preconditions;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_CONTACT;
import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_USER;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.mytests.uiobjects.example.site.pages.ContactFormPage.contactForm;

public class FormTests extends SimpleTestsInit {
/*
    @TestSkippSkipp
    public void loginTest() {
        Preconditions.shouldBeLoggedOut();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @TestSkippSkipp
    public void fillContactFormTest() {
        Preconditions.shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        contactForm.submit(DEFAULT_CONTACT);
        contactForm.check(DEFAULT_CONTACT);
    }

    @TestSkippSkipp
    public void fillContactsTest() {
        Preconditions.shouldBeLoggedIn();
        contactsPage.shouldBeOpened();
        contactsPage.asForm().submit(DEFAULT_CONTACT);
        contactsPage.asForm().check(DEFAULT_CONTACT);
    }*/
}
