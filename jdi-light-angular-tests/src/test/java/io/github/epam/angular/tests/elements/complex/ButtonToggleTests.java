package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ButtonToggleSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class ButtonToggleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyButtonToggle() {
        basicButtonToggle.is().displayed();
        basicButtonToggle.is().enabled();
        String ITALIC = "italic";
        basicButtonToggle.clickButtonToggleByValue(ITALIC);
        basicButtonToggle.is().assertButtonToggleIsSelected(ITALIC);
        basicButtonToggle.is().assertButtonToggleButtonIsPressed(ITALIC);
        basicButtonToggle.is().assertButtonToggleButtonHasText(ITALIC);
    }

    @Test
    public void verifyButtonToggleCombineSelection() {
        String BOLD = "bold";
        basicButtonToggle.clickButtonToggleByValue(BOLD);
        String UNDERLINE = "underline";
        basicButtonToggle.clickButtonToggleByValue(UNDERLINE);
        basicButtonToggle.is().assertButtonToggleIsSelected(BOLD);
        basicButtonToggle.is().assertButtonToggleIsSelected(UNDERLINE);
        basicButtonToggle.clickButtonToggleByValue(BOLD);
        basicButtonToggle.is().assertButtonToggleIsNotSelected(BOLD);
    }

    @Test
    public void verifyExclusiveButtonToggle() {
        String LEFT = "left";
        basicButtonToggleAlign.is().displayed();
        basicButtonToggleAlign.is().enabled();
        basicButtonToggleAlign.clickButtonToggleByValue(LEFT);
        basicButtonToggleAlign.is().assertButtonToggleIsSelected(LEFT);
        selectedValue.has().text("Selected value: left");
    }

    @Test
    public void verifyExclusiveButtonToggleSeparateSelection() {
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
}
