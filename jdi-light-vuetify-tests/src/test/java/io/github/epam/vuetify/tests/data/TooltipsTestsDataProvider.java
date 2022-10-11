package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.ORANGE_DARKEN_1;
import static io.github.com.enums.Colors.RED_ACCENT_2;

public class TooltipsTestsDataProvider {

    @DataProvider(name = "colorsTooltipsTestDataProvider")
    public static Object[][] colorsTooltipsTestDataProvider() {
        return new Object[][]{
                {1, BLUE_DARKEN_2.value()},
                {2, GREEN.value()},
                {3, ORANGE_DARKEN_1.value()},
                {4, RED_ACCENT_2.value()}
        };
    }
}