package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.radiobuttonsPage;
import static io.github.com.pages.RadioButtonsPage.*;

public class RadioButtonsTests extends TestsInit {


    @BeforeClass
    public void before() {
        radiobuttonsPage.open();
    }

    @Test
    public void colorsTest() {
        colorRadioButton.get(1).is().checked();
        colorRadioButton.get(1).is().color(Colors.RED.value());
        colorRadioButton.get(1).is().labelText("red");

        colorRadioButton.get(6).is().unchecked();
        colorRadioButton.get(6).check();
        colorRadioButton.get(6).is().checked();
        colorRadioButton.get(6).is().color(Colors.ORANGE_DARKEN_3.value());
        colorRadioButton.get(6).is().labelText("orange darken-3");
    }

    @Test
    public void directionTest() {
        directionRadioButton.get(1).is().groupDirection("column");
        directionRadioButton.get(3).is().groupDirection("row");
    }

    @Test
    public void mandatoryTest() {
        mandatoryRadioButton.get(1).check();
        mandatoryText.is().text("radio-1");
        mandatoryRadioButton.get(2).check();
        mandatoryText.is().text("radio-2");
    }

    @Test
    public void labelTest() {
        labelRadioButton.get(1).is().labelText("Of course it's Google");
        labelRadioButton.get(2).is().labelText("Definitely Duckduckgo");
    }
}
