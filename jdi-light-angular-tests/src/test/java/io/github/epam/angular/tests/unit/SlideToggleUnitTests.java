package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.slideToggleSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SlideToggleUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void checkTest() {
        slideToggleSection.basicSlideToggle.check();
        assertTrue(slideToggleSection.basicSlideToggle.isSelected());
    }

    @Test
    public void uncheckTest() {
        slideToggleSection.basicSlideToggle.uncheck();
        assertFalse(slideToggleSection.basicSlideToggle.isSelected());
    }

    @Test
    public void clickTest() {
        assertTrue(slideToggleSection.basicSlideToggle.isSelected());
        slideToggleSection.basicSlideToggle.click();
        assertFalse(slideToggleSection.basicSlideToggle.isSelected());
    }

    @Test
    public void testEnabledOption() {
        slideToggleSection.disableCheckbox.uncheck();
        assertTrue(slideToggleSection.resultSlideToggle.isEnabled());
    }

    @Test
    public void testDisabledOption() {
        slideToggleSection.disableCheckbox.check();
        assertTrue(slideToggleSection.resultSlideToggle.isDisabled());
    }
}
