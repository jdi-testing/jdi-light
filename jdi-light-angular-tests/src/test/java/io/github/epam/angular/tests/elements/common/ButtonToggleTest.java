package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.buttonToggleSection;
import static io.github.com.pages.AngularPage.tabsSection;
import static io.github.com.pages.sections.ButtonToggleSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

@Ignore
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
    public void verifyButtonToggle() {
        buttonToggleSection.basicButtonToggle.clickButtonByValue("italic");
        buttonToggleSection.basicButtonToggle.is().assertButtonToggleIsSelected("italic");
    }


//
//    @Test
//    public void verifyTabPanelContentByNumber() {
//        int tabNumberForTest = 3;
//        String stringForTest = String.format(DYNAMIC_CONTENT, tabNumberForTest);
//        tabsSection.basicTab.clickTab(tabNumberForTest);
//        tabsSection.basicTab.is().assertTabPanelContent(stringForTest);
//    }

  /*  @Test
    public void basicButtonToggleDisplayedTest() {
        basicButtonToggleBold.is().displayed();
        basicButtonToggleItalic.is().displayed();
        basicButtonToggleUnderline.is().displayed();
    }

    @Test
    public void basicButtonToggleEnabledTest() {
        basicButtonToggleBold.is().enabled();
        basicButtonToggleItalic.is().enabled();
        basicButtonToggleUnderline.is().enabled();
    }

    @Test
    public void basicBoldButtonToggleTest() {
        basicButtonToggleBold.click();
        basicButtonToggleBold.has().attr(pressedAttribute, buttonIsPressed);
        basicButtonToggleBold.click();
        basicButtonToggleBold.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void basicItalicButtonToggleTest() {
        basicButtonToggleItalic.click();
        basicButtonToggleItalic.has().attr(pressedAttribute, buttonIsPressed);
        basicButtonToggleItalic.click();
        basicButtonToggleItalic.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void basicUnderlineButtonToggleTest() {
        basicButtonToggleUnderline.click();
        basicButtonToggleUnderline.has().attr(pressedAttribute, buttonIsPressed);
        basicButtonToggleUnderline.click();
        basicButtonToggleUnderline.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void basicButtonToggleNamesTest() {
        basicButtonToggleBold.has().text("Bold");
        basicButtonToggleItalic.has().text("Italic");
        basicButtonToggleUnderline.has().text("Underline");
    }

    @Test
    public void pressAllBasicButtonToggleTest() {
        basicButtonToggleBold.click();
        basicButtonToggleItalic.click();
        basicButtonToggleUnderline.click();
        basicButtonToggleBold.has().attr(pressedAttribute, buttonIsPressed);
        basicButtonToggleItalic.has().attr(pressedAttribute, buttonIsPressed);
        basicButtonToggleUnderline.has().attr(pressedAttribute, buttonIsPressed);
    }

    @Test
    public void exclusiveButtonToggleDisplayedTest() {
        exclusiveButtonToggleLeft.is().displayed();
        exclusiveButtonToggleCenter.is().displayed();
        exclusiveButtonToggleRight.is().displayed();
        exclusiveButtonToggleJustify.is().displayed();
    }

    @Test
    public void exclusiveButtonToggleEnabledTest() {
        exclusiveButtonToggleLeft.is().enabled();
        exclusiveButtonToggleCenter.is().enabled();
        exclusiveButtonToggleRight.is().enabled();
        exclusiveButtonToggleJustify.is().disabled();
    }

    @Test
    public void exclusiveButtonToggleTest() {
        exclusiveButtonToggleLeft.click();
        exclusiveButtonToggleLeft.has().attr(pressedAttribute, buttonIsPressed);

        exclusiveButtonToggleCenter.click();
        exclusiveButtonToggleCenter.has().attr(pressedAttribute, buttonIsPressed);
        exclusiveButtonToggleLeft.has().attr(pressedAttribute, buttonIsNotPressed);

        exclusiveButtonToggleRight.click();
        exclusiveButtonToggleRight.has().attr(pressedAttribute, buttonIsPressed);
        exclusiveButtonToggleCenter.has().attr(pressedAttribute, buttonIsNotPressed);

        exclusiveButtonToggleLeft.click();
        exclusiveButtonToggleRight.has().attr(pressedAttribute, buttonIsNotPressed);
    }

    @Test
    public void exclusiveButtonToggleSelectedValueTest() {
        exclusiveButtonToggleLeft.click();
        selectedValue.has().text("Selected value: left");
        exclusiveButtonToggleCenter.click();
        selectedValue.has().text("Selected value: center");
        exclusiveButtonToggleRight.click();
        selectedValue.has().text("Selected value: right");
    }*/
}
