package io.github.epam.html.tests.suspend.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.bookingTime;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageTimeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
    }

    @Test
    public void setDateTimeTest() {
        bookingTime.setDateTime("05:00");
        bookingTime.show();
        assertEquals(bookingTime.value(), "05:00");
    }

    @Test
    public void isValidationTest() {
        bookingTime.is().enabled();
        bookingTime.assertThat().time(is("11:00"));
    }

    @Test
    public void labelTest() {
        assertEquals(bookingTime.label().getText(), "Booking Time:");
        bookingTime.label().is().text(equalToIgnoringCase("booking Time:"));
    }

    @Test
    public void assertValidationTest() {
        bookingTime.assertThat().date(containsString("11"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(bookingTime);
    }
}
