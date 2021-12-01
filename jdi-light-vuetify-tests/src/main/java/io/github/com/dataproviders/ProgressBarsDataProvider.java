package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.AMBER;
import static io.github.com.enums.Colors.BLACK;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.BLUE_GREY;
import static io.github.com.enums.Colors.CYAN;
import static io.github.com.enums.Colors.CYAN_DARKEN_2;
import static io.github.com.enums.Colors.DEEP_ORANGE;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.INDIGO;
import static io.github.com.enums.Colors.INDIGO_DARKEN_2;
import static io.github.com.enums.Colors.LIGHT_BLUE;
import static io.github.com.enums.Colors.LIGHT_GREEN_DARKEN_4;
import static io.github.com.enums.Colors.LIME;
import static io.github.com.enums.Colors.ORANGE;
import static io.github.com.enums.Colors.PINK;
import static io.github.com.enums.Colors.PINK_LIGHTEN_1;
import static io.github.com.enums.Colors.PINK_LIGHTEN_3;
import static io.github.com.enums.Colors.PURPLE;
import static io.github.com.enums.Colors.RED_ACCENT_2;
import static io.github.com.enums.Colors.RED_DARKEN_2;
import static io.github.com.enums.Colors.RED_LIGHTEN_2;
import static io.github.com.enums.Colors.TEAL;
import static io.github.com.enums.Colors.YELLOW_DARKEN_2;

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
                {3, GREEN.value()},
                {4, BLUE_DARKEN_2.value()}
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
                {1, AMBER.value()},
                {2, BLUE_GREY.value()},
                {3, BLUE_DARKEN_2.value()}
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
