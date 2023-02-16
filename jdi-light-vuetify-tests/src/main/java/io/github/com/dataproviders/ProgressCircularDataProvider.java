package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.AMBER;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.BLUE_GREY;
import static io.github.com.enums.Colors.BROWN;
import static io.github.com.enums.Colors.DEEP_ORANGE_LIGHTEN_2;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.INDIGO_DARKEN_2;
import static io.github.com.enums.Colors.LIME;
import static io.github.com.enums.Colors.PINK;
import static io.github.com.enums.Colors.PURPLE;
import static io.github.com.enums.Colors.RED;
import static io.github.com.enums.Colors.TEAL;

public class ProgressCircularDataProvider {

    @DataProvider(name = "colorProgressCircularsTestsDataProvider")
    public static Object[][] colorProgressCircularsTestsData() {
        return new Object[][] {
                {1, BLUE_GREY.value(), 32, 32, 100},
                {2, DEEP_ORANGE_LIGHTEN_2.value(), 32, 32, 80},
                {3, BROWN.value(), 32, 32, 60},
                {4, LIME.value(), 32, 32, 40},
                {5, INDIGO_DARKEN_2.value(), 32, 32, 20},
        };
    }

    @DataProvider(name = "indeterminateProgressCircularsTestsDataProvider")
    public static Object[][] indeterminateProgressCircularsTestsData() {
        return new Object[][] {
                {1, BLUE_DARKEN_2.value(), 32, 32 },
                {2, RED.value(), 32, 32 },
                {3, PURPLE.value(), 32, 32 },
                {4, GREEN.value(), 32, 32 },
                {5, AMBER.value(), 32, 32 },
        };
    }

    @DataProvider(name = "rotateProgressCircularsTestsDataProvider")
    public static Object[][] rotateProgressCircularsTestsData() {
        return new Object[][] {
                {1, TEAL.value(), 100, 100, 360},
                {2, BLUE_DARKEN_2.value(), 100, 100, -90},
                {3, RED.value(), 100, 100, 90},
                {4, PINK.value(), 100, 100, 180},
        };
    }

    @DataProvider(name = "sizeWidthProgressCircularsTestsDataProvider")
    public static Object[][] sizeWidthProgressCircularsTestsData() {
        return new Object[][] {
                {1, BLUE_DARKEN_2.value(), 50, 50, 4},
                {2, RED.value(), 32, 32, 3},
                {3, PURPLE.value(), 70, 70, 7},
                {4, GREEN.value(), 32, 32, 3},
                {5, AMBER.value(), 50, 50, 4},
        };
    }
}
