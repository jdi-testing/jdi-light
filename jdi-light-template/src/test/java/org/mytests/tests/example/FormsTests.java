package org.mytests.tests.example;

import org.testng.annotations.Test;

import static org.mytests.tests.example.Preconditions.shouldBeLoggedIn;
import static org.mytests.tests.example.Preconditions.shouldBeLoggedOut;
import static org.mytests.uiobjects.example.entities.Users.DEFAULT_USER;
import static org.mytests.uiobjects.example.entities.Users.USER_WITH_CONTACTS;
import static org.mytests.uiobjects.example.site.SiteJdi.contactFormPage;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;
import static org.mytests.uiobjects.example.site.pages.ContactFormPage.contactForm;
import static org.mytests.uiobjects.example.site.sections.Header.loginForm;
import static org.mytests.uiobjects.example.site.sections.Header.userIcon;


public class FormsTests extends SimpleTestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        contactForm.submit(USER_WITH_CONTACTS);
        contactForm.check(USER_WITH_CONTACTS);
    }
}
