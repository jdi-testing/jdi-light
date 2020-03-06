package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.partyTime;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DateTimeTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void getDateTest() {
        assertEquals(partyTime.value(), "2018-06-12T19:30");
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(partyTime.labelText(), "Date/time:");
    }

    @Test
    public void minTest() {
        assertEquals(partyTime.min(), "2018-05-07T00:00");
    }

    @Test
    public void maxTest() {
        assertEquals(partyTime.max(), "2018-06-14T00:00");
    }
    @Test
    public void setDateTimeTest() {
        partyTime.setDateTime("2017-05-10T00:00");
        partyTime.show();
        assertEquals(partyTime.value(), "2017-05-10T00:00");
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
