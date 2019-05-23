package io.github.epam.html.tests.suspend;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.partyTime;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageDateTimeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
    }

    @Test
    public void isValidationTest() {
        partyTime.is().date(equalToIgnoringCase("2018-06-12t19:30"));
        partyTime.is().enabled();
    }

    @Test
    public void labelTest() {
        partyTime.label().assertThat().text(is("Date/time:"));
        partyTime.label().is().text(equalToIgnoringCase("date/time:"));
    }

    @Test
    public void assertValidationTest() {
        partyTime.assertThat().date(containsString("2018"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(partyTime);
    }
}
