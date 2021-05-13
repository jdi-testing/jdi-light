package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ButtonToggleSection.basicButtonToggle;
import static io.github.com.pages.sections.ButtonToggleSection.basicButtonToggleAlign;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class ButtonToggleUnitTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void isButtonToggleSelectedTest() {
        String ITALIC = "italic";
        basicButtonToggle.clickButtonToggleByValue(ITALIC);
        assertTrue(basicButtonToggle.isButtonToggleSelected(ITALIC));
    }

    @Test
    public void isButtonToggleButtonPressedTest() {
        String BOLD = "bold";
        basicButtonToggle.clickButtonToggleByValue(BOLD);
        assertTrue(basicButtonToggle.isButtonToggleButtonPressed(BOLD));
    }

    @Test
    public void buttonToggleHasTextTest() {
        String UNDERLINE = "underline";
        basicButtonToggle.clickButtonToggleByValue(UNDERLINE);
        assertTrue(basicButtonToggle.buttonToggleHasText(UNDERLINE));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void verifyExclusiveButtonToggleJustifyButton() {
        String JUSTIFY = "justify";
        basicButtonToggleAlign.is().assertButtonToggleIsSelected(JUSTIFY);
    }
}
