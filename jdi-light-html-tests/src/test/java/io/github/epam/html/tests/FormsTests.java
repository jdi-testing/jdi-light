package io.github.epam.html.tests;

import io.github.epam.TestsInit;
import io.github.epam.html.tests.steps.Preconditions;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_CONTACT;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;

public class FormsTests extends TestsInit {

    @Test
    public void loginTest() {
        Preconditions.shouldBeLoggedOut();
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        Preconditions.shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        contactFormPage.main.contactForm.submit(DEFAULT_CONTACT);
        contactFormPage.main.contactForm.check(DEFAULT_CONTACT);
    }
}
