package io.github.com.dataproviders;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

public class ColorPickersDataProviders {

    @DataProvider
    public static Object[][] colorsDataProvider() {
        return new Object[][]{
                {Colors.RED_ACCENT_1.value(), Colors.TRANSPARENT.value()},
                {Colors.GREEN_LIGHTEN_3.value(), Colors.BLACK_TRANSPARENT_087.value()},
                {Colors.BLUE_GREY.value(), Colors.BLACK_TRANSPARENT_02.value()}
        };
    }
}
