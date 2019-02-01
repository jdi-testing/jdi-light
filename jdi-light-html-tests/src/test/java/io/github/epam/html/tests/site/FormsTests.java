package io.github.epam.html.tests.site;

import com.epam.jdi.tools.map.MapArray;
import io.github.epam.TestsInit;
import io.github.epam.html.tests.site.steps.Preconditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.usersPage;
import static io.github.com.entities.Users.DEFAULT_CONTACT;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class FormsTests extends TestsInit {

    @Test
    public void loginTest() {
        Preconditions.shouldBeLoggedOut();
        userIcon.click();
        MapArray<String, String> attrs = userIcon.attrs();
        assertThat(attrs.size(), is(3));
        assertThat(attrs.keys(), hasItem("alt"));
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        Preconditions.shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        main.contactForm.submit(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }
}
