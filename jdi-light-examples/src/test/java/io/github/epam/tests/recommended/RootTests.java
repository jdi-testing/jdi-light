package io.github.epam.tests.recommended;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.searchIcon;
import static io.github.com.pages.Header.userIcon;
import static io.github.epam.entities.Users.DEFAULT_USER;
import static io.github.epam.entities.Users.USER_WITH_CONTACTS;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedOut;

public class RootTests extends StaticTestsInit {

    @Test
    public void rootTest() {
        shouldBeLoggedOut();
        userIcon.click();
        searchIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
    }
}
