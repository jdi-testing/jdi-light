package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.birthDate;
import static io.github.com.pages.HtmlElementsPage.bookingTime;
import static io.github.com.pages.HtmlElementsPage.partyTime;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DateTimeExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void setDateTimeTest() {
        partyTime.setDateTime("2017-05-10T00:00");
        partyTime.show();
        partyTime.is().text("2017-05-10T00:00");
        bookingTime.setDateTime("05:00");
        bookingTime.show();
        bookingTime.is().text("05:00");
    }

    @Test
    public void getDateTest() {
        birthDate.is().text("1985-06-18");
    }

    @Test
    public void minMaxTest() {
        assertEquals(partyTime.min(), "2018-05-07T00:00");
        assertEquals(partyTime.max(), "2018-06-14T00:00");
    }

    @Test
    public void labelTest() {
        birthDate.label().assertThat().text(is("Birth date"));
        birthDate.label().is().text(equalToIgnoringCase("birth date"));
        birthDate.assertThat().date(containsString("1985"));
    }
}
