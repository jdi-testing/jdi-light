package io.github.epam.angular.tests;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
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
    public void basicToggleCheckedTest() {
        basicSlideToggle.check();
        basicSlideToggle.is().selected();
        basicSlideToggle.uncheck();
        basicSlideToggle.is().deselected();
    }

    @Test
    public void resultToggleColorTest() {
        disableCheckbox.uncheck();
        resultSlideToggle.check();
        primaryRadioButton.click();
        resultSlideToggle.is().hasClass("mat-primary");
        accentRadioButton.click();
        resultSlideToggle.is().hasClass("mat-accent");
        warningRadioButton.click();
        resultSlideToggle.is().hasClass("mat-warn");
    }

    @Test
    public void resultToggleCheckedTest() {
        resultSlideToggle.uncheck();
        checkedCheckbox.check();
        resultSlideToggle.is().selected();
        checkedCheckbox.uncheck();
        resultSlideToggle.is().deselected();
    }

    @Test
    public void resultToggleDisableTest() {
        disableCheckbox.check();
        resultSlideToggle.is().disabled();
        disableCheckbox.uncheck();
        resultSlideToggle.is().enabled();
    }

    @Test
    public void resultToggleLabelTextTest() {
        basicSlideToggle.label().is().displayed();
        basicSlideToggle.label().is().text("Slide me!");
    }

    @Test
    public void resultToggleAriaLabelTest() {
        String labelId = basicSlideToggle.label().attr("id");
        basicSlideToggle.has().attr("aria-labelledby", labelId);
    }

    @Test
    public void resultToggleRippleTest() {
        basicSlideToggle.find(By.className("mdc-switch__ripple")).isDisplayed();
    }
}
