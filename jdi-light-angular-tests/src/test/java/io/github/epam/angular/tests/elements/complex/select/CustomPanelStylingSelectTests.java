package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.customPanelStylingSelect;
import static org.hamcrest.Matchers.hasItems;

public class CustomPanelStylingSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        customPanelStylingSelect.show();
    }

    @Test
    public void checkLabelValue() {
        customPanelStylingSelect.label().has().value("Panel color");
    }

    @Test
    public void checkRedOptionCanBeSelectedByName() {
        customPanelStylingSelect.select(RED);
        customPanelStylingSelect.is().selected(RED);
        customPanelStylingSelect.has().color(255, 0, 0, 0.5);
    }

    @Test
    public void checkGreenOptionCanBeSelectedByName() {
        customPanelStylingSelect.select(GREEN);
        customPanelStylingSelect.is().selected(GREEN);
        customPanelStylingSelect.has().color(0, 255, 0, 0.5);
    }

    @Test
    public void checkBlueOptionCanBeSelectedByName() {
        customPanelStylingSelect.select(BLUE);
        customPanelStylingSelect.is().selected(BLUE);
        customPanelStylingSelect.has().color(0, 0, 255, 0.5);
    }

    @Test
    public void checkListDisabledOptions() {
        customPanelStylingSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        customPanelStylingSelect.has().listEnabled(Arrays.asList(RED, GREEN, BLUE));
    }
}
