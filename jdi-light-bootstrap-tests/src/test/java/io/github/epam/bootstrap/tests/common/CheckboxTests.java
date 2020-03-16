package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.*;
import static io.github.epam.states.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class CheckboxTests implements TestsInit {
    final String label = "Accept terms and conditions";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        acceptCheckbox.show();
        acceptCheckbox.check();
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(acceptCheckbox.labelText(), label);
    }

    @Test
    public void checkTest() {
        acceptCheckbox.check();
        assertTrue(acceptCheckbox.isSelected());
    }

    @Test
    public void uncheckTest() {
        acceptCheckbox.uncheck();
        assertFalse(acceptCheckbox.isSelected());
    }

    @Test
    public void clickTest() {
        assertTrue(acceptCheckbox.isSelected());
        acceptCheckbox.click();
        assertFalse(acceptCheckbox.isSelected());
    }

    @Test
    public void isValidationTest() {
        acceptCheckbox.is().selected();
        acceptCheckbox.click();
        acceptCheckbox.is().deselected().and().enabled().and().displayed();
    }

    @Test
    public void labelTest() {
        assertEquals(acceptCheckbox.label().getText(), label);
        acceptCheckbox.label().is().text(containsString("terms and conditions"));
        acceptCheckbox.label().is().text(equalToIgnoringCase("accept terms and conditions"));
    }

    @Test
    public void assertValidationTest() {
        acceptCheckbox.assertThat().selected();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(acceptCheckbox);
    }
}
