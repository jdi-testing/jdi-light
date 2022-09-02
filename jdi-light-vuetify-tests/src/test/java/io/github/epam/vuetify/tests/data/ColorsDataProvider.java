package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.RED;
import static io.github.com.enums.Colors.RED_DARKEN_3;
import static io.github.com.enums.Colors.INDIGO;
import static io.github.com.enums.Colors.INDIGO_DARKEN_3;
import static io.github.com.enums.Colors.ORANGE;
import static io.github.com.enums.Colors.ORANGE_DARKEN_3;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.GREY_DARKEN_3;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.BLUE;
import static io.github.com.enums.Colors.ORANGE_DARKEN_1;
import static io.github.com.enums.Colors.RED_ACCENT_2;

public class ColorsDataProvider {

    @DataProvider(name = "customColorsTestDataProvider")
    public static Object[][] customColorsCheckboxesTestsData() {
        return new Object[][] {
                {1, RED.value()},
                {2, RED_DARKEN_3.value()},
                {3, INDIGO.value()},
                {4, INDIGO_DARKEN_3.value()},
                {5, ORANGE.value()},
                {6, ORANGE_DARKEN_3.value()},
                {7, BLUE_DARKEN_2.value()},
                {8, GREY_DARKEN_3.value()},
                {9, GREEN.value()},
                {10, BLUE.value()},
                {11, ORANGE_DARKEN_1.value()},
                {12, RED_ACCENT_2.value()},
        };
    }
}
