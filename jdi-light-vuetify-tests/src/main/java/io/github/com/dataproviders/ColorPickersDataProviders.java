package io.github.com.dataproviders;

import com.epam.jdi.light.vuetify.elements.complex.ColorPicker;
import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.vuetify.elements.complex.ColorPicker.initialRGBAStringColor;

public class ColorPickersDataProviders {

    @DataProvider
    public static Object[][] colorsDataProvider() {
        return new Object[][]{
                {initialRGBAStringColor, Colors.RED_ACCENT_1.value(), Colors.TRANSPARENT.value()},
                {initialRGBAStringColor, Colors.GREEN_LIGHTEN_3.value(), Colors.BLACK_TRANSPARENT_087.value()},
                {initialRGBAStringColor, Colors.BLUE_GREY.value(), Colors.BLACK_TRANSPARENT_02.value()}
        };
    }

}
