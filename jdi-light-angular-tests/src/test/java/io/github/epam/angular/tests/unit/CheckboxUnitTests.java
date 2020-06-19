package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.checkboxSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void checkTest() {
        checkboxSection.basicCheckbox.check();
        assertTrue(checkboxSection.basicCheckbox.isSelected());
    }

    @Test
    public void uncheckTest() {
        checkboxSection.basicCheckbox.uncheck();
        assertFalse(checkboxSection.basicCheckbox.isSelected());
    }

    @Test
    public void clickTest() {
        assertTrue(checkboxSection.basicCheckbox.isSelected());
        checkboxSection.basicCheckbox.click();
        assertFalse(checkboxSection.basicCheckbox.isSelected());
    }

    @Test
    public void testEnabledOption() {
        checkboxSection.configurableDisabledCheckbox.uncheck();
        assertTrue(checkboxSection.configurableResultCheckbox.isEnabled());
    }

    @Test
    public void testDisabledOption() {
        checkboxSection.configurableDisabledCheckbox.check();
        assertTrue(checkboxSection.configurableResultCheckbox.isDisabled());
    }
}
