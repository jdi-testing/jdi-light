package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SlideToggleSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SlideToggleUnitTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void checkTest() {
        basicSlideToggle.check();
        assertTrue(basicSlideToggle.isSelected());
    }

    @Test
    public void uncheckTest() {
        basicSlideToggle.uncheck();
        assertFalse(basicSlideToggle.isSelected());
    }

    @Test
    public void clickTest() {
        assertTrue(basicSlideToggle.isSelected());
        basicSlideToggle.click();
        assertFalse(basicSlideToggle.isSelected());
    }

    @Test
    public void testEnabledOption() {
        disableCheckbox.uncheck();
        assertTrue(resultSlideToggle.isEnabled());
    }

    @Test
    public void testDisabledOption() {
        disableCheckbox.check();
        assertTrue(resultSlideToggle.isDisabled());
    }
}
