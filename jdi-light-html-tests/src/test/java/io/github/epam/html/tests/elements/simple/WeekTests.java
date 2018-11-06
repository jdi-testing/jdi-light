package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.autumnWeek;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class WeekTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
        autumnWeek.setDateTime("2018-W40");
    }

    @Test
    public void getDateTest() {
        assertEquals(autumnWeek.value(), "2018-W40");
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(autumnWeek.labelText(), "Autumn");
    }

    @Test
    public void minTest() {
        assertEquals(autumnWeek.min(), "2018-W35");
    }

    @Test
    public void maxTest() {
        assertEquals(autumnWeek.max(), "2018-W48");
    }

    @Test
    public void setDateTimeTest() {
        autumnWeek.setDateTime("2018-W12");
        autumnWeek.hover();
        assertEquals(autumnWeek.value(), "2018-W12");
    }

    @Test
    public void isValidationTest() {
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
