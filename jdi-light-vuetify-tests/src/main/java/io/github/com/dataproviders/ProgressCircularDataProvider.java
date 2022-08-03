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

    @DataProvider(name = "colorProgressSpinnersTestsDataProvider")
    public static Object[][] colorProgressSpinnersTestsData() {
        return new Object[][] {
                {1, BLUE_GREY.value(), "32px", "32px" },
                {2, DEEP_ORANGE_LIGHTEN_2.value(), "32px", "32px" },
                {3, BROWN.value(), "32px", "32px" },
                {4, LIME.value(), "32px", "32px" },
                {5, INDIGO_DARKEN_2.value(), "32px", "32px" },
        };
    }

    @DataProvider(name = "indeterminateProgressSpinnersTestsDataProvider")
    public static Object[][] indeterminateProgressSpinnersTestsData() {
        return new Object[][] {
                {1, BLUE_DARKEN_2.value(), "32px", "32px" },
                {2, RED.value(), "32px", "32px" },
                {3, PURPLE.value(), "32px", "32px" },
                {4, GREEN.value(), "32px", "32px" },
                {5, AMBER.value(), "32px", "32px" },
        };
    }

    @DataProvider(name = "rotateProgressSpinnersTestsDataProvider")
    public static Object[][] rotateProgressSpinnersTestsData() {
        return new Object[][] {
                {1, TEAL.value(), "100px", "100px" },
                {2, BLUE_DARKEN_2.value(), "100px", "100px" },
                {3, RED.value(), "100px", "100px" },
                {4, PINK.value(), "100px", "100px" },
        };
    }

    @DataProvider(name = "sizeWidthProgressSpinnersTestsDataProvider")
    public static Object[][] sizeWidthProgressSpinnersTestsData() {
        return new Object[][] {
                {1, BLUE_DARKEN_2.value(), "50px", "50px" },
                {2, RED.value(), "32px", "32px" },
                {3, PURPLE.value(), "70px", "70px" },
                {4, GREEN.value(), "32px", "32px" },
                {5, AMBER.value(), "50px", "50px" },
        };
    }
}
