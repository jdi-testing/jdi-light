package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class CheckboxTests implements TestsInit {
    final String label = "Accept terms and conditions";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        acceptConditions.check();
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(acceptConditions.labelText(), label);
    }

    @Test
    public void checkTest() {
        acceptConditions.check();
        assertTrue(acceptConditions.isSelected());
    }
    @Test
    public void uncheckTest() {
        acceptConditions.uncheck();
        assertFalse(acceptConditions.isSelected());
    }

    @Test
    public void clickTest() {
        assertTrue(acceptConditions.isSelected());
        acceptConditions.click();
        assertFalse(acceptConditions.isSelected());
    }

    @Test
    public void isValidationTest() {
        acceptConditions.is().selected();
        acceptConditions.click();
        acceptConditions.is().deselected().and().enabled().and().displayed();
    }

    @Test
    public void labelTest() {
        assertEquals(acceptConditions.label().getText(), label);
        acceptConditions.label().is().text(containsString("terms and conditions"));
        acceptConditions.label().is().text(equalToIgnoringCase("accept terms and conditions"));
    }
    @Test
    public void assertValidationTest() {
        acceptConditions.assertThat().selected();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(acceptConditions);
    }
}
