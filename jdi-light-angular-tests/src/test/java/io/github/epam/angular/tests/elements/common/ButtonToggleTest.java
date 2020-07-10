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
    public void basicButtonToggleDisplayedTest() {
        buttonToggleSection.basicButtonToggleBold.isDisplayed();
        buttonToggleSection.basicButtonToggleItalic.isDisplayed();
        buttonToggleSection.basicButtonToggleUnderline.isDisplayed();
    }

    @Test
    public void basicButtonToggleEnabledTest() {
        buttonToggleSection.basicButtonToggleBold.is().enabled();
        buttonToggleSection.basicButtonToggleItalic.is().enabled();
        buttonToggleSection.basicButtonToggleUnderline.is().enabled();
    }

    @Test
    public void basicBoldButtonToggleTest() {
        String pressedAttribute = "aria-pressed";
        String buttonIsPressed = "true";
        String buttonIsNotPressed = "false";
        buttonToggleSection.basicButtonToggleBold.click();
        buttonToggleSection.basicButtonToggleBold.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.basicButtonToggleBold.click();
        buttonToggleSection.basicButtonToggleBold.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void basicItalicButtonToggleTest() {
        String pressedAttribute = "aria-pressed";
        String buttonIsPressed = "true";
        String buttonIsNotPressed = "false";
        buttonToggleSection.basicButtonToggleItalic.click();
        buttonToggleSection.basicButtonToggleItalic.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.basicButtonToggleItalic.click();
        buttonToggleSection.basicButtonToggleItalic.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void basicUnderlineButtonToggleTest() {
        String pressedAttribute = "aria-pressed";
        String buttonIsPressed = "true";
        String buttonIsNotPressed = "false";
        buttonToggleSection.basicButtonToggleUnderline.click();
        buttonToggleSection.basicButtonToggleUnderline.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.basicButtonToggleUnderline.click();
        buttonToggleSection.basicButtonToggleUnderline.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void basicButtonToggleNamesTest() {
        buttonToggleSection.basicButtonToggleBold.has().text("Bold");
        buttonToggleSection.basicButtonToggleItalic.has().text("Italic");
        buttonToggleSection.basicButtonToggleUnderline.has().text("Underline");
    }

    @Test
    public void pressAllBasicButtonTogglesTest() {
        String pressedAttribute = "aria-pressed";
        String buttonIsPressed = "true";
        buttonToggleSection.basicButtonToggleBold.click();
        buttonToggleSection.basicButtonToggleItalic.click();
        buttonToggleSection.basicButtonToggleUnderline.click();
        buttonToggleSection.basicButtonToggleBold.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.basicButtonToggleItalic.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.basicButtonToggleUnderline.has().attr(pressedAttribute, buttonIsPressed);
    }

    @Test
    public void exclusiveButtonToggleDisplayedTest() {
        buttonToggleSection.exclusiveButtonToggleLeft.isDisplayed();
        buttonToggleSection.exclusiveButtonToggleCenter.isDisplayed();
        buttonToggleSection.exclusiveButtonToggleRight.isDisplayed();
        buttonToggleSection.exclusiveButtonToggleJustify.isDisplayed();
    }

    @Test
    public void exclusiveButtonToggleEnabledTest() {
        buttonToggleSection.exclusiveButtonToggleLeft.is().enabled();
        buttonToggleSection.exclusiveButtonToggleCenter.is().enabled();
        buttonToggleSection.exclusiveButtonToggleRight.is().enabled();
        buttonToggleSection.exclusiveButtonToggleJustify.is().disabled();
    }

    @Test
    public void exclusiveButtonToggleTest() {
        String pressedAttribute = "aria-pressed";
        String buttonIsPressed = "true";
        String buttonIsNotPressed = "false";
        buttonToggleSection.exclusiveButtonToggleLeft.click();
        buttonToggleSection.exclusiveButtonToggleLeft.has().attr(pressedAttribute, buttonIsPressed);

        buttonToggleSection.exclusiveButtonToggleCenter.click();
        buttonToggleSection.exclusiveButtonToggleCenter.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.exclusiveButtonToggleLeft.has().attr(pressedAttribute, buttonIsNotPressed);

        buttonToggleSection.exclusiveButtonToggleRight.click();
        buttonToggleSection.exclusiveButtonToggleRight.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.exclusiveButtonToggleCenter.has().attr(pressedAttribute, buttonIsNotPressed);

        buttonToggleSection.exclusiveButtonToggleLeft.click();
        buttonToggleSection.exclusiveButtonToggleRight.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void exclusiveButtonToggleSelectedValueTest() {
        buttonToggleSection.exclusiveButtonToggleLeft.click();
        buttonToggleSection.selectedValue.has().text("Selected value: left");
        buttonToggleSection.exclusiveButtonToggleCenter.click();
        buttonToggleSection.selectedValue.has().text("Selected value: center");
        buttonToggleSection.exclusiveButtonToggleRight.click();
        buttonToggleSection.selectedValue.has().text("Selected value: right");
    }
}
