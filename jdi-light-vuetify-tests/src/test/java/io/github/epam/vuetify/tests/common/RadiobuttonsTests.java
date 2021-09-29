package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.radiobuttonsPage;
import static io.github.com.pages.RadiobuttonsPage.*;

public class RadiobuttonsTests extends TestsInit {

    @BeforeSuite
    public void before() {
        radiobuttonsPage.open();
    }

    @Test
    public void demoTest() {
        colorRadiobutton.get(1).is().checked();
        colorRadiobutton.get(2).is().unchecked();
        colorRadiobutton.get(1).is().color(Colors.RED.value());
        colorRadiobutton.get(1).is().labelText("red");
        colorRadiobutton.get(2).is().labelText("red darken-3");

        directionRadiobutton.get(1).is().groupDirection("column");
        directionRadiobutton.get(3).is().groupDirection("row");

        mandatoryRadiobutton.get(1).check();
        mandatoryText.is().text("radio-1");
        mandatoryRadiobutton.get(2).check();
        mandatoryText.is().text("radio-2");

        labelRadiobutton.get(1).is().labelText("Of course it's Google");
        labelRadiobutton.get(2).is().labelText("Definitely Duckduckgo");
    }
}
