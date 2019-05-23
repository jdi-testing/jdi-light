package io.github.epam.html.tests.suspend;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.monthDate;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageMonthTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
        monthDate.setDateTime("2018-05");
    }

    @Test
    public void setDateTimeTest() {
        monthDate.setDateTime("2018-10");
        monthDate.show();
        assertEquals(monthDate.value(), "2018-10");
    }

    @Test
    public void isValidationTest() {
        monthDate.is().month(containsString("-05"));
        monthDate.is().enabled();
    }

    @Test
    public void labelTest() {
        monthDate.label().is().text(containsString("Holidays"));
        monthDate.label().is().text(equalToIgnoringCase("month of holidays"));
    }

    @Test
    public void assertValidationTest() {
        monthDate.assertThat().date(containsString("2018"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(monthDate);
    }
}
