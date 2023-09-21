package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonTogglePage;
import static io.github.com.pages.ButtonTogglePage.*;


public class ButtonToggleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonTogglePage.open();
        waitCondition(() -> buttonTogglePage.isOpened());
        buttonTogglePage.checkOpened();
    }

    @Test(description="Test checks that button toggle buttons can be selected")
    public void verifyButtonToggle() {
        basicButtonToggle.show();
        basicButtonToggle.is().displayed();
        basicButtonToggle.is().enabled();
        String VALUE1 = "value1";
        basicButtonToggle.clickButtonToggleByValue(VALUE1);
        basicButtonToggle.is().assertButtonToggleIsSelected(VALUE1);
        basicButtonToggle.is().assertButtonToggleButtonIsPressed(VALUE1);
        basicButtonToggle.is().assertButtonToggleButtonHasText(VALUE1, "Value 1");
    }

    @Test(description = "Test checks button toggle feature: multiple buttons selection")
    public void verifyButtonToggleCombineSelection() {
        basicButtonToggleMultipleSelect.show();
        String VALUE1 = "value1";
        basicButtonToggleMultipleSelect.clickButtonToggleByValue(VALUE1);
        String VALUE2 = "value2";
        basicButtonToggleMultipleSelect.clickButtonToggleByValue(VALUE2);
        basicButtonToggleMultipleSelect.is().assertButtonToggleIsSelected(VALUE1);
        basicButtonToggleMultipleSelect.is().assertButtonToggleIsSelected(VALUE2);
        basicButtonToggleMultipleSelect.clickButtonToggleByValue(VALUE1);
        basicButtonToggleMultipleSelect.is().assertButtonToggleIsNotSelected(VALUE1);
    }

    @Test(description = "Test checks button-toggle functionality")
    public void verifyExclusiveButtonToggle() {
        basicButtonToggleAlign.show();
        String LEFT = "left";
        String JUSTIFY = "justify";
        String ARIALABEL = "Text align justify";
        basicButtonToggleAlign.is().displayed();
        basicButtonToggleAlign.is().enabled();
        basicButtonToggleAlign.clickButtonToggleByValue(LEFT);
        basicButtonToggleAlign.is().assertButtonToggleIsSelected(LEFT);
        selectedValue.has().text("Selected value: left");
        basicButtonToggleAlign.is().assertButtonInButtonToggleIsDisabled(JUSTIFY);
        basicButtonToggleAlign.is().assertButtonToggleHasValue(JUSTIFY);
        basicButtonToggleAlign.is().assertButtonToggleHasAriaLabel(JUSTIFY, ARIALABEL);
    }

    @Test(description = "Test checks button-toggle feature: exclusive button selection")
    public void verifyExclusiveButtonToggleSeparateSelection() {
        basicButtonToggleAlign.show();
        String CENTER = "center";
        String LEFT = "left";
        String RIGHT = "right";
        basicButtonToggleAlign.clickButtonToggleByValue(CENTER);
        basicButtonToggleAlign.clickButtonToggleByValue(RIGHT);
        basicButtonToggleAlign.clickButtonToggleByValue(LEFT);
        basicButtonToggleAlign.is().assertButtonToggleIsSelected(LEFT);
        basicButtonToggleAlign.is().assertButtonToggleIsNotSelected(RIGHT);
        basicButtonToggleAlign.is().assertButtonToggleIsNotSelected(CENTER);
    }

    @Test(description = "Test checks button-toggle functionality with appearance legacy")
    public void verifyAppearanceLegacyButtonToggleFunctionality() {
        buttonToggleAppearance.show();
        buttonToggleAppearance.is().displayed();
        buttonToggleAppearance.is().enabled();
        String VALUE1 = "value1";
        buttonToggleAppearance.clickButtonToggleByValue(VALUE1);
        buttonToggleAppearance.is().assertButtonToggleIsSelected(VALUE1);
        buttonToggleAppearance.is().assertButtonToggleHasLegacyAppearance();
    }

    @Test(description = "Test checks button-toggle is disabled")
    public void verifyButtonToggleIsDisabled() {
        buttonToggleDisabled.show();
        buttonToggleDisabled.is().assertButtonToggleIsDisabled();
    }

    @Test(description = "Test checks button-toggle is in vertical position")
    public void verifyButtonToggleIsVertical() {
        buttonToggleVertical.show();
        buttonToggleVertical.is().assertButtonToggleVertical();
    }

    @Test(description = "Test checks presence of ripple effect for the button-toggle")
    public void verifyButtonToggleRipple () {
        buttonToggleRippleDisabled.show();
        String VALUE_1 = "value 1";
        String VALUE2 = "value2";
        buttonToggleRippleDisabled.is().assertButtonToggleNoRipple(VALUE_1);
        buttonToggleVertical.is().assertButtonToggleWithRipple(VALUE2);
    }
}
