package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.buttonToggleSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class ButtonToggleTest extends TestsInit {
    private final String pressedAttribute = "aria-pressed";
    private final String buttonIsPressed = "true";
    private final String buttonIsNotPressed = "false";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicButtonToggleDisplayedTest() {
        buttonToggleSection.basicButtonToggleBold.is().displayed();
        buttonToggleSection.basicButtonToggleItalic.is().displayed();
        buttonToggleSection.basicButtonToggleUnderline.is().displayed();
    }

    @Test
    public void basicButtonToggleEnabledTest() {
        buttonToggleSection.basicButtonToggleBold.is().enabled();
        buttonToggleSection.basicButtonToggleItalic.is().enabled();
        buttonToggleSection.basicButtonToggleUnderline.is().enabled();
    }

    @Test
    public void basicBoldButtonToggleTest() {
        buttonToggleSection.basicButtonToggleBold.click();
        buttonToggleSection.basicButtonToggleBold.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.basicButtonToggleBold.click();
        buttonToggleSection.basicButtonToggleBold.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void basicItalicButtonToggleTest() {
        buttonToggleSection.basicButtonToggleItalic.click();
        buttonToggleSection.basicButtonToggleItalic.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.basicButtonToggleItalic.click();
        buttonToggleSection.basicButtonToggleItalic.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void basicUnderlineButtonToggleTest() {
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
    public void pressAllBasicButtonToggleTest() {
        buttonToggleSection.basicButtonToggleBold.click();
        buttonToggleSection.basicButtonToggleItalic.click();
        buttonToggleSection.basicButtonToggleUnderline.click();
        buttonToggleSection.basicButtonToggleBold.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.basicButtonToggleItalic.has().attr(pressedAttribute, buttonIsPressed);
        buttonToggleSection.basicButtonToggleUnderline.has().attr(pressedAttribute, buttonIsPressed);
    }

    @Test
    public void exclusiveButtonToggleDisplayedTest() {
        buttonToggleSection.exclusiveButtonToggleLeft.is().displayed();
        buttonToggleSection.exclusiveButtonToggleCenter.is().displayed();
        buttonToggleSection.exclusiveButtonToggleRight.is().displayed();
        buttonToggleSection.exclusiveButtonToggleJustify.is().displayed();
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
