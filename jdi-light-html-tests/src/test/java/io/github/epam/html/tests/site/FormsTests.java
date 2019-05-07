package io.github.epam.html.tests.site;

import com.epam.jdi.tools.map.MapArray;
import io.github.epam.TestsInit;
import io.github.epam.html.tests.site.steps.States;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_CONTACT;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class FormsTests extends TestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        userIcon.click();
        MapArray<String, String> attrs = userIcon.attrs();
        attrs = attrs.filter((k,v) -> isNotBlank(v));
        assertThat(attrs.size(), is(2));
        assertThat(attrs.keys(), hasItem("src"));
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        main.contactForm.submit(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }
}
