package io.github.epam.vuetify.tests.complex;

import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.colorPickersPage;
import static io.github.com.pages.ColorPickersPage.fullCanvasColorPicker;
import static io.github.com.pages.ColorPickersPage.swatchesColorPicker;

public class ColorPickerTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        colorPickersPage.open();
        colorPickersPage.checkOpened();
    }

    @Test
    public void colorPickerElementsTest() {
//        String stringColorValue = Colors.GREEN_LIGHTEN_3.value();
        String stringColorValue = "rgba(165, 214, 167, 0.88)";
//        String stringColorValue = "rgb(165, 214, 167)";
//        String stringColorValue = "hsla(122, 0,37, 0,74, 1)";
//        String stringColorValue = "hsl(122, 0,37, 0,74)";
//        String stringColorValue = "hsl(122, 0.37, 0.74)";
//        String stringColorValue = "hsla(122, 0.37, 0.74, 1)";
//        String stringColorValue = "#A5D6A7FF";
        fullCanvasColorPicker.setColor(stringColorValue);
        Assert.assertEquals(Color.fromString(stringColorValue), fullCanvasColorPicker.getColor());
    }

}
