package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.radioButtonsPage;
import static io.github.com.pages.RadioButtonsPage.*;

public class RadioButtonsTests extends TestsInit {


    @BeforeClass
    public void before() {
        radioButtonsPage.open();
    }

    @Test
    public void demoTest() throws InterruptedException {
        colorRadioButtons.select(3);
        //Thread.sleep(2000);
        System.out.println(colorRadioButtons.list().size());
        colorRadioButtons.list().selected(3);
        //colorRadioButtons.is().selected(3);
    }

//    @Test
//    public void colorsTest() {
//        colorRadioButtons.get(1).is().checked();
//        colorRadioButtons.get(1).is().color(Colors.RED.value());
//        colorRadioButtons.get(1).is().labelText("red");
//
//        colorRadioButtons.get(6).is().unchecked();
//        colorRadioButtons.get(6).check();
//        colorRadioButtons.get(6).is().checked();
//        colorRadioButtons.get(6).is().color(Colors.ORANGE_DARKEN_3.value());
//        colorRadioButtons.get(6).is().labelText("orange darken-3");
//    }
//
//    @Test
//    public void directionTest() {
//        directionRadioButtons.get(1).is().groupDirection("column");
//        directionRadioButtons.get(3).is().groupDirection("row");
//    }
//
//    @Test
//    public void mandatoryTest() {
//        mandatoryRadioButtons.get(1).check();
//        mandatoryText.is().text("radio-1");
//        mandatoryRadioButtons.get(2).check();
//        mandatoryText.is().text("radio-2");
//    }
//
//    @Test
//    public void labelTest() {
//        labelRadioButtons.get(1).is().labelText("Of course it's Google");
//        labelRadioButtons.get(2).is().labelText("Definitely Duckduckgo");
//    }
}
