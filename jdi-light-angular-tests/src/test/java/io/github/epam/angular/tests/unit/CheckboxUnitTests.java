package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.CheckboxSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.*;

public class CheckboxUnitTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        disabledCheckbox.show();
    }

    @Test
    public void checkTest() {
        basicCheckbox.check();
        assertTrue(basicCheckbox.isSelected());
    }

    @Test
    public void uncheckTest() {
        basicCheckbox.uncheck();
        assertFalse(basicCheckbox.isSelected());
    }

    @Test
    public void labelTest() {
        assertEquals(basicCheckbox.label().getValue(), "Check me!");
    }

    @Test
    public void indeterminateTest() {
        indeterminateCheckbox.click();
        assertTrue(resultCheckbox.isIndeterminate());
    }

    @Test
    public void enabledOptionTest() {
        disabledCheckbox.uncheck();
        assertTrue(resultCheckbox.isEnabled());
    }

    @Test
    public void disabledOptionTest() {
        disabledCheckbox.check();
        assertTrue(resultCheckbox.isDisabled());
    }

}
