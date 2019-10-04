package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.autumnWeek;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class WeekTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
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
