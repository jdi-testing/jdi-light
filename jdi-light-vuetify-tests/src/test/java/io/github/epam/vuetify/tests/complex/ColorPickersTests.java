package io.github.epam.vuetify.tests.complex;

import io.github.com.dataproviders.ColorPickersDataProviders;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.ALPHA_HEX_LENGTH;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.HEX;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.HEXA;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.HSL;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.HSLA;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.INITIAL_HEX_STRING_COLOR;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.INITIAL_RGBA_STRING_COLOR;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.NO_ALPHA_HEX_LENGTH;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.RGB;
import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.RGBA;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.colorPickersPage;
import static io.github.com.pages.ColorPickersPage.dropdownInput;
import static io.github.com.pages.ColorPickersPage.dropdownInputColorPicker;
import static io.github.com.pages.ColorPickersPage.elevationColorPicker;
import static io.github.com.pages.ColorPickersPage.flatColorPicker;
import static io.github.com.pages.ColorPickersPage.fullCanvasColorPicker;
import static io.github.com.pages.ColorPickersPage.hexModelButton;
import static io.github.com.pages.ColorPickersPage.hexaModelButton;
import static io.github.com.pages.ColorPickersPage.hslaModelButton;
import static io.github.com.pages.ColorPickersPage.hsvaModelButton;
import static io.github.com.pages.ColorPickersPage.modelColorPicker;
import static io.github.com.pages.ColorPickersPage.noCanvasColorPicker;
import static io.github.com.pages.ColorPickersPage.noInputsColorPicker;
import static io.github.com.pages.ColorPickersPage.rgbaModelButton;
import static io.github.com.pages.ColorPickersPage.smallSwatchesColorPicker;

public class ColorPickersTests extends TestsInit {

    @BeforeClass
    public void before() {
        colorPickersPage.open();
        waitCondition(() -> colorPickersPage.isOpened());
        colorPickersPage.checkOpened();
    }

    @Test(dataProviderClass = ColorPickersDataProviders.class, dataProvider = "colorsDataProvider",
            description = "Test checks color picking from a full canvas")
    public void fullCanvasColorPickerTest(String colorValue,
                                          String transparentColorValue) {
        fullCanvasColorPicker.show();
        double initialHueSliderStyle = fullCanvasColorPicker.hueSlider().value();
        double initialAlphaSliderStyle = fullCanvasColorPicker.alphaSlider().value();
        fullCanvasColorPicker.setColor(colorValue);
        fullCanvasColorPicker.has().dotColor(colorValue)
                .and().hueSliderValue(Matchers.not(initialHueSliderStyle));
        fullCanvasColorPicker.setColor(transparentColorValue);
        fullCanvasColorPicker.has().dotColor(transparentColorValue)
                .and().alphaSliderValue(Matchers.not(initialAlphaSliderStyle));
    }

    // @todo #5310 Test is not stable, as initial state can differ from RGBA
    @Test(description = "Test checks color picking from a non-canvas slider")
    public void noCanvasColorPickerTest() {
        noCanvasColorPicker.show();
        noCanvasColorPicker.has().inputModel(RGBA);
        noCanvasColorPicker.changeEditStyleButton().click();
        noCanvasColorPicker.has().inputModel(HSLA);
        noCanvasColorPicker.changeEditStyleButton().click();
        noCanvasColorPicker.has().inputModel(HEX)
                .and().hexInputFieldStringColorValue(INITIAL_HEX_STRING_COLOR);
    }

    @Test(description = "Test checks that color picker is elevated")
    public void elevationColorPickerTest() {
        elevationColorPicker.show();
        elevationColorPicker.is().elevated();
        flatColorPicker.show();
        flatColorPicker.is().notElevated();
    }

    @Test(description = "Test checks color picker without input fields")
    public void noInputColorPickerTest() {
        noInputsColorPicker.show();
        noInputsColorPicker.has().hueSliderValue(Matchers.notNullValue())
                .and().alphaSliderValue(Matchers.notNullValue())
                .and().dotColor(INITIAL_RGBA_STRING_COLOR);
    }

    @Test(description = "Test checks different color schemes in color picker")
    public void dropdownInputColorPickerTest() {
        dropdownInputColorPicker.show();
        dropdownInput.select(HSLA.toLowerCase());
        dropdownInputColorPicker.has().inputModel(HSLA);
        dropdownInput.select(RGBA.toLowerCase());
        dropdownInputColorPicker.has().inputModel(RGBA);
        dropdownInput.select(HEXA.toLowerCase());
        dropdownInputColorPicker.has().inputModel(HEX);
    }

    @Test(description = "Test checks that color picker appears correctly according to selected color schemes")
    public void modelColorPickerTest() {
        modelColorPicker.show();
        hexModelButton.click();
        modelColorPicker.has().inputModel(RGB);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HSL);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HEX)
                .and().hexInputFieldLength(NO_ALPHA_HEX_LENGTH);
        modelColorPicker.changeEditStyleButton().click();

        hexaModelButton.click();
        modelColorPicker.has().inputModel(RGBA);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HSLA);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HEX)
                .and().hexInputFieldLength(ALPHA_HEX_LENGTH);
        modelColorPicker.changeEditStyleButton().click();

        rgbaModelButton.click();
        modelColorPicker.has().inputModel(RGBA);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HSLA);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HEX)
                .and().hexInputFieldLength(ALPHA_HEX_LENGTH);
        modelColorPicker.changeEditStyleButton().click();

        hslaModelButton.click();
        modelColorPicker.has().inputModel(RGBA);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HSLA);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HEX);
        modelColorPicker.has().hexInputFieldLength(ALPHA_HEX_LENGTH);
        modelColorPicker.changeEditStyleButton().click();

        hsvaModelButton.click();
        modelColorPicker.has().inputModel(RGBA);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HSLA);
        modelColorPicker.changeEditStyleButton().click();
        modelColorPicker.has().inputModel(HEX)
                .and().hexInputFieldLength(ALPHA_HEX_LENGTH);
    }

    @Test(description = "Test checks dark and light themes of color picker")
    public void themeColorPickerTest() {
        fullCanvasColorPicker.show();
        fullCanvasColorPicker.has().lightTheme();
        smallSwatchesColorPicker.show();
        smallSwatchesColorPicker.has().darkTheme();
    }
}
