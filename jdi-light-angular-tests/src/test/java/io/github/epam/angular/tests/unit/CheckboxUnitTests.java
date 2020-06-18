package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.*;
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
        basicCheckbox.check();
        assertTrue(basicCheckbox.isSelected());
    }

    @Test
    public void uncheckTest() {
        basicCheckbox.uncheck();
        assertFalse(basicCheckbox.isSelected());
    }

    @Test
    public void clickTest() {
        assertTrue(basicCheckbox.isSelected());
        basicCheckbox.click();
        assertFalse(basicCheckbox.isSelected());
    }

    @Test
    public void testEnabledOption() {
        configurableDisabledCheckbox.uncheck();
        assertTrue(configurableResultCheckbox.isEnabled());
    }

    @Test
    public void testDisabledOption() {
        configurableDisabledCheckbox.check();
        assertTrue(configurableResultCheckbox.isDisabled());
    }
}
