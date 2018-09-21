package io.github.epam.tests.staticPO;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.Test;

import static io.github.epam.entities.Users.DEFAULT_USER;
import static io.github.epam.entities.Users.USER_WITH_CONTACTS;
import static io.github.epam.tests.staticPO.steps.Preconditions.shouldBeLoggedIn;
import static io.github.epam.tests.staticPO.steps.Preconditions.shouldBeLoggedOut;
import static staticPageObject.StaticSite.contactFormPage;
import static staticPageObject.StaticSite.homePage;
import static staticPageObject.pages.Header.loginForm;
import static staticPageObject.pages.Header.userIcon;

public class FormsTests extends StaticTestsInit {

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
        contactFormPage.main.contactForm.submit(USER_WITH_CONTACTS);
        contactFormPage.main.contactForm.check(USER_WITH_CONTACTS);
    }
}
