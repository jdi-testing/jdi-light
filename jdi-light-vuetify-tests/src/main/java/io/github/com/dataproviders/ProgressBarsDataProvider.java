package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.AMBER;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLACK;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_GREY;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.CYAN;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.CYAN_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.DEEP_ORANGE;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREEN;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.INDIGO;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.INDIGO_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.LIGHT_BLUE;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.LIGHT_GREEN_DARKEN_4;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.LIME;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.ORANGE;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PINK;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PINK_LIGHTEN_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PINK_LIGHTEN_3;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PURPLE;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_ACCENT_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.TEAL;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.YELLOW_DARKEN_2;

public class ProgressBarsDataProvider {

    @DataProvider(name = "bufferValueProgressBarsTestsDataProvider")
    public static Object[][] bufferValueProgressBarsTestsData() {
        return new Object[][] {
                {1, BLUE_DARKEN_2.value()},
                {2, PURPLE.value()},
                {3, RED_LIGHTEN_2.value()},
                {4, BLACK.value()}
        };
    }

    @DataProvider(name = "colorsProgressBarsTestsDataProvider")
    public static Object[][] colorsProgressBarsTestsData() {
        return new Object[][] {
                {1, PINK_LIGHTEN_3.value(), PINK_LIGHTEN_1.value()},
                {2, BLUE_GREY.value(), LIME.value()},
                {3, GREEN.value(), RED_ACCENT_2.value()}
        };
    }

    @DataProvider(name = "indeterminateProgressBarsTestsDataProvider")
    public static Object[][] indeterminateProgressBarsTestsData() {
        return new Object[][] {
                {1, YELLOW_DARKEN_2.value()},
                {2, GREEN.value()},
                {3, TEAL.value()},
                {4, CYAN.value()}
        };
    }

    @DataProvider(name = "reversedProgressBarsTestsDataProvider")
    public static Object[][] reversedProgressBarsTestsData() {
        return new Object[][] {
                {1, PINK.value()},
                {2, LIME.value()},
                {3, GREEN.value()}
        };
    }

    @DataProvider(name = "roundedProgressBarsTestsDataProvider")
    public static Object[][] roundedProgressBarsTestsData() {
        return new Object[][] {
                {1, RED_DARKEN_2.value()},
                {2, INDIGO.value()},
                {3, TEAL.value()},
                {4, CYAN_DARKEN_2.value()}
        };
    }

    @DataProvider(name = "streamProgressBarsTestsDataProvider")
    public static Object[][] streamProgressBarsTestsData() {
        return new Object[][] {
                {1, RED_LIGHTEN_2.value()},
                {2, TEAL.value()},
                {3, CYAN.value()},
                {4, ORANGE.value()}
        };
    }

    @DataProvider(name = "stripedProgressBarsTestsDataProvider")
    public static Object[][] stripedProgressBarsTestsData() {
        return new Object[][] {
                {1, LIGHT_BLUE.value()},
                {2, LIGHT_GREEN_DARKEN_4.value()},
                {3, LIME.value()},
                {4, DEEP_ORANGE.value()}
        };
    }

    @DataProvider(name = "defaultProgressBarsTestsDataProvider")
    public static Object[][] defaultProgressBarsTestsData() {
        return new Object[][] {
                {1, LIGHT_BLUE.value()},
                {2, LIGHT_GREEN_DARKEN_4.value()},
                {3, LIME.value()}
        };
    }

    @DataProvider(name = "determinateProgressBarsTestsDataProvider")
    public static Object[][] determinateProgressBarsTestsData() {
        return new Object[][] {
                {1, DEEP_PURPLE_ACCENT_4.value()},
                {2, PINK.value()},
                {3, INDIGO_DARKEN_2.value()},
                {4, AMBER.value()}
        };
    }
}
