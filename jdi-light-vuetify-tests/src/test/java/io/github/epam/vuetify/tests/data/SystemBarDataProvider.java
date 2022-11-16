package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.INDIGO_DARKEN_2;
import static io.github.com.enums.Colors.RED_LIGHTEN_2;

public class SystemBarDataProvider {

    @DataProvider(name = "coloredSystemBarsTestData")
    public static Object[][] coloredSystemBarsTestData() {
        return new Object[][]{
                {1, BLUE_DARKEN_2.value()},
                {2, RED_LIGHTEN_2.value()},
                {3, INDIGO_DARKEN_2.value()}
        };
    }
}
