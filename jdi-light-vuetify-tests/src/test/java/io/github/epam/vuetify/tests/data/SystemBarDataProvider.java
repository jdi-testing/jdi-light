package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.RED_LIGHTEN_2;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;

public class SystemBarDataProvider {

    @DataProvider(name = "coloredSystemBarsTestData")
    public static Object[][] coloredSystemBarsTestData() {
        return new Object[][]{
                {1, "System bar color 1", BLUE_DARKEN_2.value()},
                {2, "System bar color 2", RED_LIGHTEN_2.value()},
                {3, "System bar color 3", BLUE_DARKEN_2.value()}
        };
    }
}
