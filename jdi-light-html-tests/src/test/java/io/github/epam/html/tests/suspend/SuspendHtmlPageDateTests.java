package io.github.epam.html.tests.suspend;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.birthDate;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageDateTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
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
