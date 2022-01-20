package io.github.com.dataproviders;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.INITIAL_RGBA_STRING_COLOR;

public class ColorPickersDataProviders {

    @DataProvider
    public static Object[][] colorsDataProvider() {
        return new Object[][]{
                {INITIAL_RGBA_STRING_COLOR, Colors.RED_ACCENT_1.value(), Colors.TRANSPARENT.value()},
                {INITIAL_RGBA_STRING_COLOR, Colors.GREEN_LIGHTEN_3.value(), Colors.BLACK_TRANSPARENT_087.value()},
                {INITIAL_RGBA_STRING_COLOR, Colors.BLUE_GREY.value(), Colors.BLACK_TRANSPARENT_02.value()}
        };
    }

}
