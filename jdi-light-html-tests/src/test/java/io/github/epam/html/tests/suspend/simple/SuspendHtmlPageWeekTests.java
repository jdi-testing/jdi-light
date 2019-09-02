package io.github.epam.html.tests.suspend.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.autumnWeek;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageWeekTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
        autumnWeek.setDateTime("2018-W40");
    }

    @Test
    public void setDateTimeTest() {
        autumnWeek.setDateTime("2018-W12");
        autumnWeek.show();
        assertEquals(autumnWeek.value(), "2018-W12");
    }

    @Test
    public void isValidationTest() {
        autumnWeek.is().enabled();
        autumnWeek.assertThat().week(is("2018-W40"));
    }

    @Test
    public void labelTest() {
        autumnWeek.label().assertThat().text(is("Autumn"));
        autumnWeek.label().is().text(equalToIgnoringCase("autumn"));
    }

    @Test
    public void assertValidationTest() {
        autumnWeek.assertThat().date(containsString("W40"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(autumnWeek);
    }
}
