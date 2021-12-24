package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.elements.complex.ColorPicker;
import io.github.com.dataproviders.ColorPickersDataProviders;
import io.github.epam.TestsInit;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.github.com.StaticSite.colorPickersPage;
import static io.github.com.pages.ColorPickersPage.noCanvasColorPicker;
import static io.github.com.pages.ColorPickersPage.fullCanvasColorPicker;
import static io.github.com.pages.ColorPickersPage.flatColorPicker;
import static io.github.com.pages.ColorPickersPage.elevationColorPicker;
import static io.github.com.pages.ColorPickersPage.mediumSwatchesColorPicker;
import static io.github.com.pages.ColorPickersPage.smallSwatchesColorPicker;
import static io.github.com.pages.ColorPickersPage.bigSwatchesColorPicker;


public class ColorPickerTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        colorPickersPage.open();
        colorPickersPage.checkOpened();
    }

    @Test(dataProviderClass = ColorPickersDataProviders.class, dataProvider = "colorsDataProvider")
    public void fullCanvasColorPickerTest(String initialRGBAStringColor,
                                          String stringColorValue,
                                          String stringTransparentColorValue) {
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
        noCanvasColorPicker.has().inputModel(ColorPicker.RGBA);
        noCanvasColorPicker.button().click();
        noCanvasColorPicker.has().inputModel(ColorPicker.HSLA);
        noCanvasColorPicker.button().click();
        noCanvasColorPicker.has().inputModel(ColorPicker.HEX);
        Assert.assertEquals(noCanvasColorPicker.inputHEX().getText(), ColorPicker.initialHEXStringColor);
        noCanvasColorPicker.button().click();
    }

    @Test
    public void elevationColorPickerTest() {
        elevationColorPicker.is().elevated();
        flatColorPicker.is().notElevated();
    }

    @Test
    public void smallSwatchesColorPickerTest() {
        ArrayList<Color> colors = smallSwatchesColorPicker.getColorsFromSwatches();
        for (Color color : colors) {
            smallSwatchesColorPicker.setColor(color.asRgba());
            smallSwatchesColorPicker.has().color(color.asRgba());
        }
    }

    @Test
    public void mediumSwatchesColorPickerTest() {
        WebList colorElements = mediumSwatchesColorPicker.getColorElementsFromSwatches();
        for (UIElement colorElement : colorElements) {
            colorElement.click();
            Color color = mediumSwatchesColorPicker.getColor(colorElement.find(ColorPicker.DIV));
            mediumSwatchesColorPicker.has().color(color.asRgba());
        }
    }

    @Test
    public void bigSwatchesColorPickerTest() {
        WebList colorElements = bigSwatchesColorPicker.getColorElementsFromSwatches();
        for (UIElement colorElement : colorElements) {
            colorElement.click();
            Color color = bigSwatchesColorPicker.getColor(colorElement.find(ColorPicker.DIV));
            bigSwatchesColorPicker.has().color(color.asRgba());
        }
    }

}