package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.dataproviders.ColorPickersDataProviders;
import io.github.epam.TestsInit;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.HSLA;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.RGBA;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.RGB;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.HSL;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.HEX;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.HEXA;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.INITIAL_HEX_STRING_COLOR;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.INITIAL_RGBA_STRING_COLOR;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.NO_ALPHA_HEX_LENGTH;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.ALPHA_HEX_LENGTH;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.DIV;
import static com.jdiai.tools.Timer.waitCondition;
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

    @BeforeClass
    public void before() {
        colorPickersPage.open();
        waitCondition(() -> colorPickersPage.isOpened());
        colorPickersPage.checkOpened();
    }

    @Test(dataProviderClass = ColorPickersDataProviders.class, dataProvider = "colorsDataProvider")
    public void fullCanvasColorPickerTest(String colorValue,
                                          String transparentColorValue) {
        String initialHueSliderStyle = fullCanvasColorPicker.hueSlider().getValue();
        String initialAlphaSliderStyle = fullCanvasColorPicker.alphaSlider().getValue();
        fullCanvasColorPicker.setColor(colorValue);
        fullCanvasColorPicker.has().color(colorValue);
        fullCanvasColorPicker.assertThat().hueSliderValueHaveChanged(initialHueSliderStyle);
        fullCanvasColorPicker.setColor(transparentColorValue);
        fullCanvasColorPicker.has().color(transparentColorValue);
        fullCanvasColorPicker.assertThat().alphaSliderValueHaveChanged(initialAlphaSliderStyle);
    }

    @Test
    public void noCanvasColorPickerTest() {
        noCanvasColorPicker.has().inputModel(RGBA);
        noCanvasColorPicker.colorModelButton().click();
        noCanvasColorPicker.has().inputModel(HSLA);
        noCanvasColorPicker.colorModelButton().click();
        noCanvasColorPicker.has().inputModel(HEX);
        noCanvasColorPicker.has().hexInputFieldStringColorValue(INITIAL_HEX_STRING_COLOR);
        noCanvasColorPicker.colorModelButton().click();
    }

    @Test
    public void elevationColorPickerTest() {
        elevationColorPicker.is().elevated();
        flatColorPicker.is().notElevated();
    }

    @Test
    public void noInputColorPickerTest() {
        noInputsColorPicker.has().canvasStyle();
        noInputsColorPicker.has().canvasDotStyle();
        noInputsColorPicker.has().hueSliderValue();
        noInputsColorPicker.has().alphaSliderValue();
        noInputsColorPicker.has().color(INITIAL_RGBA_STRING_COLOR);
    }

    @Test
    public void dropdownInputColorPickerTest() {
        dropdownInput.select(HSLA.toLowerCase());
        dropdownInputColorPicker.has().inputModel(HSLA);
        dropdownInput.select(RGBA.toLowerCase());
        dropdownInputColorPicker.has().inputModel(RGBA);
        dropdownInput.select(HEXA.toLowerCase());
        dropdownInputColorPicker.has().inputModel(HEX);
    }

    @Test
    public void modelColorPickerTest() {
        hexModelButton.click();
        modelColorPicker.has().inputModel(RGB);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HSL);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HEX);
        modelColorPicker.has().hexInputFieldLength(NO_ALPHA_HEX_LENGTH);
        modelColorPicker.colorModelButton().click();

        hexaModelButton.click();
        modelColorPicker.has().inputModel(RGBA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HSLA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HEX);
        modelColorPicker.has().hexInputFieldLength(ALPHA_HEX_LENGTH);
        modelColorPicker.colorModelButton().click();

        rgbaModelButton.click();
        modelColorPicker.has().inputModel(RGBA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HSLA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HEX);
        modelColorPicker.has().hexInputFieldLength(ALPHA_HEX_LENGTH);
        modelColorPicker.colorModelButton().click();

        hslaModelButton.click();
        modelColorPicker.has().inputModel(RGBA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HSLA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HEX);
        modelColorPicker.has().hexInputFieldLength(ALPHA_HEX_LENGTH);
        modelColorPicker.colorModelButton().click();

        hsvaModelButton.click();
        modelColorPicker.has().inputModel(RGBA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HSLA);
        modelColorPicker.colorModelButton().click();
        modelColorPicker.has().inputModel(HEX);
        modelColorPicker.has().hexInputFieldLength(ALPHA_HEX_LENGTH);
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
            Color color = mediumSwatchesColorPicker.getColor(swatch.find(DIV));
            mediumSwatchesColorPicker.has().color(color.asRgba());
        }
    }

    @Test
    public void bigSwatchesColorPickerTest() {
        for (UIElement swatch : bigSwatchesColorPicker.swatches()) {
            swatch.click();
            Color color = bigSwatchesColorPicker.getColor(swatch.find(DIV));
            bigSwatchesColorPicker.has().color(color.asRgba());
        }
    }
}
