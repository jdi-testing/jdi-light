package io.github.epam.tests.recommended;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.ContactFormPage.*;
import static io.github.com.pages.Header.*;
import static io.github.epam.entities.Users.*;
import static io.github.epam.tests.recommended.steps.Preconditions.*;

public class FormsTests extends StaticTestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
        userName.is().displayed();
    }

    @Test
    public void fillContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        main.contactForm.submit(USER_WITH_CONTACTS);
        main.contactForm.check(USER_WITH_CONTACTS);
    }
}
