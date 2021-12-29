package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.ColorPicker;
import io.github.com.dataproviders.ColorPickersDataProviders;
import io.github.epam.TestsInit;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.github.com.StaticSite.colorPickersPage;
import static io.github.com.pages.ColorPickersPage.fullCanvasColorPicker;
import static io.github.com.pages.ColorPickersPage.noCanvasColorPicker;
import static io.github.com.pages.ColorPickersPage.elevationColorPicker;
import static io.github.com.pages.ColorPickersPage.flatColorPicker;
import static io.github.com.pages.ColorPickersPage.noInputsColorPicker;
import static io.github.com.pages.ColorPickersPage.dropdownInputColorPicker;
import static io.github.com.pages.ColorPickersPage.dropdownInput;
import static io.github.com.pages.ColorPickersPage.modelColorPicker;
import static io.github.com.pages.ColorPickersPage.rgbaModelButton;
import static io.github.com.pages.ColorPickersPage.hslaModelButton;
import static io.github.com.pages.ColorPickersPage.hsvaModelButton;
import static io.github.com.pages.ColorPickersPage.hexModelButton;
import static io.github.com.pages.ColorPickersPage.hexaModelButton;
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
        noCanvasColorPicker.colorModelButton().click();
        noCanvasColorPicker.has().inputModel(ColorPicker.HSLA);
        noCanvasColorPicker.colorModelButton().click();
        noCanvasColorPicker.has().inputModel(ColorPicker.HEX);
        //TODO: make assertion in ColorPickerAssert class
        Assert.assertEquals(noCanvasColorPicker.inputHEX().getText(), ColorPicker.INITIAL_HEX_STRING_COLOR);
        noCanvasColorPicker.colorModelButton().click();
    }

    @Test
    public void elevationColorPickerTest() {
        elevationColorPicker.is().elevated();
        flatColorPicker.is().notElevated();
    }

    @Test
    public void noInputColorPickerTest() {
        noInputsColorPicker.hueSlider().slideHorizontalTo(200);
//        noInputsColorPicker.alphaSlider().slideHorizontalTo(0.5);
        Color color = noInputsColorPicker.getColor(noInputsColorPicker.colorDot());
        Assert.assertEquals(color, Color.fromString("rgba(0, 169, 255, 1)"));
    }

    @Test
    public void dropdownInputColorPickerTest() {
        dropdownInput.select(1);
        dropdownInputColorPicker.has().inputModel(ColorPicker.HSLA);
        dropdownInput.select(2);
        dropdownInputColorPicker.has().inputModel(ColorPicker.RGBA);
        dropdownInput.select(3);
        dropdownInputColorPicker.has().inputModel(ColorPicker.HEX);
    }

    @Test
    public void modelColorPickerTest() {
        hexModelButton.click();
        modelColorPicker.has().inputModel(ColorPicker.RGB);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HSL);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HEX);
        modelColorPicker.has().hexInputFieldLength(ColorPicker.NO_ALPHA_HEX_LENGTH);
        modelColorPicker.colorModelButton().click();

        hexaModelButton.click();
        modelColorPicker.has().inputModel(ColorPicker.RGBA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HSLA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HEX);
        modelColorPicker.has().hexInputFieldLength(ColorPicker.ALPHA_HEX_LENGTH);
        modelColorPicker.colorModelButton().click();

        rgbaModelButton.click();
        modelColorPicker.has().inputModel(ColorPicker.RGBA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HSLA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HEX);
        modelColorPicker.has().hexInputFieldLength(ColorPicker.ALPHA_HEX_LENGTH);
        modelColorPicker.colorModelButton().click();

        hslaModelButton.click();
        modelColorPicker.has().inputModel(ColorPicker.RGBA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HSLA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HEX);
        modelColorPicker.has().hexInputFieldLength(ColorPicker.ALPHA_HEX_LENGTH);
        modelColorPicker.colorModelButton().click();

        hsvaModelButton.click();
        modelColorPicker.has().inputModel(ColorPicker.RGBA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HSLA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(ColorPicker.HEX);
        modelColorPicker.has().hexInputFieldLength(ColorPicker.ALPHA_HEX_LENGTH);

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
        for (UIElement swatch : mediumSwatchesColorPicker.swatches()) {
            swatch.click();
            Color color = mediumSwatchesColorPicker.getColor(swatch.find(ColorPicker.DIV));
            mediumSwatchesColorPicker.has().color(color.asRgba());
        }
    }

    @Test
    public void bigSwatchesColorPickerTest() {
        for (UIElement swatch : bigSwatchesColorPicker.swatches()) {
            swatch.click();
            Color color = bigSwatchesColorPicker.getColor(swatch.find(ColorPicker.DIV));
            bigSwatchesColorPicker.has().color(color.asRgba());
        }
    }

}