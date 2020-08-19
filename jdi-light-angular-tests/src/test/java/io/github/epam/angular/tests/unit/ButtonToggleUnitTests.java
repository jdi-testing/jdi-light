package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ButtonToggleSection.basicButtonToggle;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class ButtonToggleUnitTests extends TestsInit {

    private final String ITALIC = "italic";
    private final String BOLD = "bold";
    private final String UNDERLINE = "underline";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void isButtonToggleSelectedTest() {
        basicButtonToggle.clickButtonToggleByValue(ITALIC);
        assertTrue(basicButtonToggle.isButtonToggleSelected(ITALIC));
    }

    @Test
    public void isButtonToggleButtonPressedTest() {
        basicButtonToggle.clickButtonToggleByValue(BOLD);
        assertTrue(basicButtonToggle.isButtonToggleButtonPressed(BOLD));
    }

    @Test
    public void buttonToggleHasTextTest() {
        basicButtonToggle.clickButtonToggleByValue(UNDERLINE);
        assertTrue(basicButtonToggle.buttonToggleHasText(UNDERLINE));
    }
}
