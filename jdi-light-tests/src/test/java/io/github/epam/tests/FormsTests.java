package io.github.epam.tests;

import io.github.epam.SimpleTestsInit;
import org.testng.annotations.Test;

import static io.github.epam.EpamGithubSite.*;
import static io.github.epam.entities.Users.DEFAULT_USER;
import static io.github.epam.entities.Users.USER_WITH_CONTACTS;
import static io.github.epam.steps.Preconditions.loggedIn;
import static io.github.epam.steps.Preconditions.loggedOut;

public class FormsTests extends SimpleTestsInit {

    @Test
    public void loginTest() {
        loggedOut();
        header.userIcon.click();
        header.loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
    }
    @Test
    public void fillContactFormTest() {
        loggedIn();
        contactFormPage.shouldBeOpened();
        contactFormPage.checkOpened();
        contactFormPage.main.contactForm.submit(USER_WITH_CONTACTS);
        contactFormPage.main.contactForm.check(USER_WITH_CONTACTS);
    }
}
