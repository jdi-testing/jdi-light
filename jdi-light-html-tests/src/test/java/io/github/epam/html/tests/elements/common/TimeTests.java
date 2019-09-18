package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.bookingTime;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class TimeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void getDateTest() {
        assertEquals(bookingTime.value(), "11:00");
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(bookingTime.labelText(), "Booking Time:");
    }

    @Test
    public void minTest() {
        assertEquals(bookingTime.min(), "9:00");
    }

    @Test
    public void maxTest() {
        assertEquals(bookingTime.max(), "18:00");
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
