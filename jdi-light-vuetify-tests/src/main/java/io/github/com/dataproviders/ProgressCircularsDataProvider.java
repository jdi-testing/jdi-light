package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.AMBER;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_GREY;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BROWN;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.DEEP_ORANGE_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREEN;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.INDIGO_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.LIME;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PINK;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PURPLE;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.TEAL;

public class ProgressCircularsDataProvider {

    @DataProvider(name = "colorProgressCircularsTestsDataProvider")
    public static Object[][] colorProgressCircularsTestsData() {
        return new Object[][] {
                {1, BLUE_GREY.value(), "32px", "32px" },
                {2, DEEP_ORANGE_LIGHTEN_2.value(), "32px", "32px" },
                {3, BROWN.value(), "32px", "32px" },
                {4, LIME.value(), "32px", "32px" },
                {5, INDIGO_DARKEN_2.value(), "32px", "32px" },
        };
    }

    @DataProvider(name = "indeterminateProgressCircularsTestsDataProvider")
    public static Object[][] indeterminateProgressCircularsTestsData() {
        return new Object[][] {
                {1, BLUE_DARKEN_2.value(), "32px", "32px" },
                {2, RED.value(), "32px", "32px" },
                {3, PURPLE.value(), "32px", "32px" },
                {4, GREEN.value(), "32px", "32px" },
                {5, AMBER.value(), "32px", "32px" },
        };
    }

    @DataProvider(name = "rotateProgressCircularsTestsDataProvider")
    public static Object[][] rotateProgressCircularsTestsData() {
        return new Object[][] {
                {1, TEAL.value(), "100px", "100px" },
                {2, BLUE_DARKEN_2.value(), "100px", "100px" },
                {3, RED.value(), "100px", "100px" },
                {4, PINK.value(), "100px", "100px" },
        };
    }

    @DataProvider(name = "sizeWidthProgressCircularsTestsDataProvider")
    public static Object[][] sizeWidthProgressCircularsTestsData() {
        return new Object[][] {
                {1, BLUE_DARKEN_2.value(), "50px", "50px" },
                {2, RED.value(), "32px", "32px" },
                {3, PURPLE.value(), "70px", "70px" },
                {4, GREEN.value(), "32px", "32px" },
                {5, AMBER.value(), "50px", "50px" },
        };
    }
}
