package io.github.epam.vuetify.tests.complex;

import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.github.com.StaticSite.colorPickersPage;
import static io.github.com.pages.ColorPickersPage.*;

public class ColorPickerTests extends TestsInit {

    private final String RGBA = "RGBA";
    private final String HSLA = "HSLA";
    private final String HEX = "HEX";
    private final String stringColorValue = Colors.GREEN_LIGHTEN_3.value();
    private final String stringTransparentColorValue = Colors.BLACK_TRANSPARENT_087.value();
    private final String initialRGBAStringColor = "rgba(255, 0, 0, 1)";
    private final String initialStringHEXColor = "#FF0000FF";
    private final Color initialColor = Color.fromString(initialRGBAStringColor);

    @BeforeMethod
    public void beforeTest() {
        colorPickersPage.open();
        colorPickersPage.checkOpened();
    }

    @Test
    public void fullCanvasColorPickerTest() {
        fullCanvasColorPicker.has().canvasStyle();
        fullCanvasColorPicker.has().canvasDotStyle();
        fullCanvasColorPicker.has().hueSliderValue();
        fullCanvasColorPicker.has().alphaSliderValue();
        fullCanvasColorPicker.has().color(initialRGBAStringColor);
        String initialHueSliderStyle = fullCanvasColorPicker.hueSlider().getValue();
        String initialAlphaSliderStyle = fullCanvasColorPicker.alphaSlider().getValue();
        fullCanvasColorPicker.setColor(stringColorValue);
        fullCanvasColorPicker.has().color(stringColorValue);
        fullCanvasColorPicker.assertThat().hueSliderValueHaveChanged(initialHueSliderStyle);
        fullCanvasColorPicker.setColor(stringTransparentColorValue);
        fullCanvasColorPicker.has().color(stringTransparentColorValue);
        fullCanvasColorPicker.assertThat().alphaSliderValueHaveChanged(initialAlphaSliderStyle);
    }

    @Test
    public void noCanvasColorPickerTest() {
        noCanvasColorPicker.has().inputModel(RGBA);
        noCanvasColorPicker.button().click();
        noCanvasColorPicker.has().inputModel(HSLA);
        noCanvasColorPicker.button().click();
        noCanvasColorPicker.has().inputModel(HEX);
        Assert.assertEquals(noCanvasColorPicker.inputHEX().getText(), initialStringHEXColor);
        noCanvasColorPicker.button().click();
    }

    @Test
    public void elevationColorPickerTest() {
        elevationColorPicker.is().elevated();
        flatColorPicker.is().notElevated();
    }

    @Test
    public void swatchesColorPickerTest() {
//        middleSwatchesColorPicker.getColorFromSwatches();
        ArrayList<Color> colors = smallSwatchesColorPicker.getColorsFromSwatches();
        for (Color color : colors) {
            smallSwatchesColorPicker.setColor(color.asRgba());
        }

//        bigSwatchesColorPicker.getColorFromSwatches();
    }

}