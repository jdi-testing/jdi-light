package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.sections.SelectSection.customPanelStylingSelect;
import static org.testng.Assert.assertTrue;

public class CustomPanelStylingSelectTests extends TestsSelectBase {
    @BeforeMethod()
    public void before() {
        customPanelStylingSelect.show();
    }

    @Test
    public void checkLabelValue() {
        customPanelStylingSelect.label().has().value("Panel color");
    }

    @Test
    public void checkRedOptionCanBeSelectedByName() {
        String red = "Red";
        customPanelStylingSelect.select(red);
        customPanelStylingSelect.is().selected(red);
        assertTrue(customPanelStylingSelect.hasColor(255, 0, 0, 0.5),
                   String.format("The selected color should be medium %s", red));
    }

    @Test
    public void checkGreenOptionCanBeSelectedByName() {
        String green = "Green";
        customPanelStylingSelect.select(green);
        customPanelStylingSelect.is().selected(green);
        assertTrue(customPanelStylingSelect.hasColor(0, 255, 0, 0.5),
                   String.format("The selected color should be medium %s", green));
    }

    @Test
    public void checkBlueOptionCanBeSelectedByName() {
        String blue = "Blue";
        customPanelStylingSelect.select(blue);
        customPanelStylingSelect.is().selected(blue);
        assertTrue(customPanelStylingSelect.hasColor(0, 0, 255, 0.5),
                   String.format("The selected color should be medium %s", blue));
    }
}
