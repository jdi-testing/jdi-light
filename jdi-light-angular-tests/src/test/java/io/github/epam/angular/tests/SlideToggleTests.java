package io.github.epam.angular.tests;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SlideToggleSection.accentRadioButton;
import static io.github.com.pages.sections.SlideToggleSection.basicSlideToggle;
import static io.github.com.pages.sections.SlideToggleSection.checkedCheckbox;
import static io.github.com.pages.sections.SlideToggleSection.colorRadioButtons;
import static io.github.com.pages.sections.SlideToggleSection.disableCheckbox;
import static io.github.com.pages.sections.SlideToggleSection.primaryRadioButton;
import static io.github.com.pages.sections.SlideToggleSection.resultSlideToggle;
import static io.github.com.pages.sections.SlideToggleSection.warningRadioButton;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SlideToggleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicTest() {
        basicSlideToggle.is().displayed();
        resultSlideToggle.is().displayed();
        checkedCheckbox.is().displayed();
        disableCheckbox.is().displayed();
        colorRadioButtons.is().displayed();
    }

    @Test
    public void resultToggleColorTest() {
        disableCheckbox.uncheck();
        resultSlideToggle.check();
        primaryRadioButton.click();
        assertTrue(resultSlideToggle.hasClass("mat-primary"));
        accentRadioButton.click();
        assertTrue(resultSlideToggle.hasClass("mat-accent"));
        warningRadioButton.click();
        assertTrue(resultSlideToggle.hasClass("mat-warn"));
    }

    @Test
    public void basicToggleCheckedTest() {
        basicSlideToggle.check();
        assertTrue(basicSlideToggle.isSelected());
        basicSlideToggle.uncheck();
        assertFalse(basicSlideToggle.isSelected());
    }

    @Test
    public void resultToggleCheckedTest() {
        resultSlideToggle.uncheck();
        checkedCheckbox.check();
        assertTrue(resultSlideToggle.isSelected());
        checkedCheckbox.uncheck();
        assertFalse(resultSlideToggle.isSelected());
    }

    @Test
    public void resultToggleDisableTest() {
        disableCheckbox.check();
        assertTrue(resultSlideToggle.isDisabled());
        disableCheckbox.uncheck();
        assertTrue(resultSlideToggle.isEnabled());
    }
}
