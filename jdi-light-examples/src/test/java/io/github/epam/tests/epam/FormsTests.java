package io.github.epam.tests.epam;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.Test;

import static io.github.epam.EpamGithubSite.contactFormPage;
import static io.github.epam.EpamGithubSite.header;
import static io.github.epam.EpamGithubSite.homePage;
import static io.github.epam.entities.UsersUtils.DEFAULT_USER;
import static io.github.epam.entities.UsersUtils.USER_WITH_CONTACTS;
import static io.github.epam.tests.epam.steps.Preconditions.shouldBeLoggedIn;
import static io.github.epam.tests.epam.steps.Preconditions.shouldBeLoggedOut;

public class FormsTests extends StaticTestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        header.userIcon.click();
        header.loginForm.login(DEFAULT_USER);
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
