package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.acceptConditions;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.testng.Assert.*;

public class CheckboxTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        acceptConditions.check();
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(acceptConditions.labelText(),
            "Accept terms and conditions");
    }

    @Test
    public void checkTest() {
        acceptConditions.check();
        assertEquals(acceptConditions.isSelected(), true);
    }
    @Test
    public void uncheckTest() {
        acceptConditions.uncheck();
        assertEquals(acceptConditions.isSelected(), false);
    }

    @Test
    public void clickTest() {
        acceptConditions.click();
        assertFalse(acceptConditions.isSelected());
        acceptConditions.click();
        assertTrue(acceptConditions.isSelected());
    }

    @Test
    public void isSelecetedTest() {
        assertTrue(acceptConditions.isSelected());
        acceptConditions.click();
        assertFalse(acceptConditions.isSelected());
    }

    @Test
    public void isValidationTest() {
        acceptConditions.is().selected(true);
    }

    @Test
    public void labelTest() {
        assertEquals(acceptConditions.label().getText(),
            "Accept terms and conditions");
        acceptConditions.label().is().text(containsString("terms and conditions"));
        acceptConditions.label().is().text(equalToIgnoringCase("accept terms and conditions"));
    }
    @Test
    public void assertValidationTest() {
        acceptConditions.assertThat().selected(true);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(acceptConditions);
    }
}
