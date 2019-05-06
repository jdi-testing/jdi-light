package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.birthDate;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DateTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void getDateTest() {
        assertEquals(birthDate.value(), "1985-06-18");
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(birthDate.labelText(), "Birth date");
    }

    @Test
    public void minTest() {
        assertEquals(birthDate.min(), "1970-01-01");
    }

    @Test
    public void maxTest() {
        assertEquals(birthDate.max(), "2030-12-31");
    }

    @Test
    public void setDateTimeTest() {
        birthDate.setDateTime("2018-11-13");
        assertEquals(birthDate.value(), "2018-11-13");
    }

    @Test
    public void isValidationTest() {
        birthDate.is().date(is("1985-06-18"));
        birthDate.is().enabled();
    }

    @Test
    public void labelTest() {
        assertEquals(birthDate.label().getText(), "Birth date");
        birthDate.label().is().text(containsString("Birth"));
    }

    @Test
    public void assertValidationTest() {
        birthDate.assertThat().date(containsString("1985"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(birthDate);
    }
}
