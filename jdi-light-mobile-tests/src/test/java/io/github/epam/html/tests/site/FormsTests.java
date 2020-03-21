package io.github.epam.html.tests.site;

import com.epam.jdi.tools.map.MapArray;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.ContactFormPage.*;
import static io.github.com.pages.Header.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class FormsTests implements TestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        loginForm.shouldBeOpened();
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
    @Test
    public void attrsTest() {
        shouldBeLoggedOut();
        MapArray<String, String> attrs = userIcon.core().attrs();
        attrs = attrs.filter((k,v) -> isNotBlank(v));
        assertThat(attrs.size(), is(2));
        assertThat(attrs.keys(), hasItem("src"));
    }
}
