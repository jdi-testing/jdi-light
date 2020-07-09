package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.buttonToggleSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class ButtonToggleTest extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicButtonToggleTest() {
        buttonToggleSection.basicButtonToggleBold.isDisplayed();
        buttonToggleSection.basicButtonToggleBold.click();
        buttonToggleSection.basicButtonToggleBold.has().attr("aria-pressed", "true");
        buttonToggleSection.basicButtonToggleBold.click();
        buttonToggleSection.basicButtonToggleBold.has().attr("aria-pressed", "false");

        buttonToggleSection.basicButtonToggleItalic.isDisplayed();
        buttonToggleSection.basicButtonToggleItalic.click();
        buttonToggleSection.basicButtonToggleItalic.has().attr("aria-pressed", "true");
        buttonToggleSection.basicButtonToggleItalic.click();
        buttonToggleSection.basicButtonToggleItalic.has().attr("aria-pressed", "false");

        buttonToggleSection.basicButtonToggleUnderline.isDisplayed();
        buttonToggleSection.basicButtonToggleUnderline.click();
        buttonToggleSection.basicButtonToggleUnderline.has().attr("aria-pressed", "true");
        buttonToggleSection.basicButtonToggleUnderline.click();
        buttonToggleSection.basicButtonToggleUnderline.has().attr("aria-pressed", "false");
    }

    @Test
    public void basicButtonToggleNamesTest() {
        buttonToggleSection.basicButtonToggleBold.has().text("Bold");
        buttonToggleSection.basicButtonToggleItalic.has().text("Italic");
        buttonToggleSection.basicButtonToggleUnderline.has().text("Underline");
    }

    @Test
    public void pressAllBasicButtonTogglesTest() {
        buttonToggleSection.basicButtonToggleBold.isDisplayed();
        buttonToggleSection.basicButtonToggleBold.click();
        buttonToggleSection.basicButtonToggleItalic.isDisplayed();
        buttonToggleSection.basicButtonToggleItalic.click();
        buttonToggleSection.basicButtonToggleUnderline.isDisplayed();
        buttonToggleSection.basicButtonToggleUnderline.click();
        buttonToggleSection.basicButtonToggleBold.has().attr("aria-pressed", "true");
        buttonToggleSection.basicButtonToggleItalic.has().attr("aria-pressed", "true");
        buttonToggleSection.basicButtonToggleUnderline.has().attr("aria-pressed", "true");
    }

    @Test
    public void exclusiveButtonToggleTest() {
        buttonToggleSection.exclusiveButtonToggleLeft.isDisplayed();
        buttonToggleSection.exclusiveButtonToggleLeft.click();
        buttonToggleSection.exclusiveButtonToggleLeft.has().attr("aria-pressed", "true");
        buttonToggleSection.selectedValue.has().text("Selected value: left");

        buttonToggleSection.exclusiveButtonToggleCenter.isDisplayed();
        buttonToggleSection.exclusiveButtonToggleCenter.click();
        buttonToggleSection.exclusiveButtonToggleCenter.has().attr("aria-pressed", "true");
        buttonToggleSection.exclusiveButtonToggleLeft.has().attr("aria-pressed", "false");
        buttonToggleSection.selectedValue.has().text("Selected value: center");

        buttonToggleSection.exclusiveButtonToggleRight.isDisplayed();
        buttonToggleSection.exclusiveButtonToggleRight.click();
        buttonToggleSection.exclusiveButtonToggleRight.has().attr("aria-pressed", "true");
        buttonToggleSection.exclusiveButtonToggleCenter.has().attr("aria-pressed", "false");
        buttonToggleSection.selectedValue.has().text("Selected value: right");

        buttonToggleSection.exclusiveButtonToggleJustify.isDisplayed();
        buttonToggleSection.exclusiveButtonToggleJustify.is().disabled();

        buttonToggleSection.exclusiveButtonToggleLeft.click();
        buttonToggleSection.exclusiveButtonToggleRight.has().attr("aria-pressed", "false");
    }
}
