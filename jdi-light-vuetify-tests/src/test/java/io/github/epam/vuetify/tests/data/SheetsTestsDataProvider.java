package io.github.epam.vuetify.tests.data;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

public class SheetsTestsDataProvider {

    @DataProvider(name = "elevationSheetsTestData")
    public static Object[][] elevationSheetsTestData() {
        return new Object[][]{
                {1, 6},
                {2, 12},
                {3, 18}
        };
    }

    @DataProvider(name = "colorSheetsTestData")
    public static Object[][] colorSheetsTestData() {
        return new Object[][]{
                {1, Colors.GREY_LIGHTEN_3.value()},
                {2, Colors.GREEN_LIGHTEN_3.value()},
                {3, Colors.YELLOW_LIGHTEN_3.value()},
                {4, Colors.RED_LIGHTEN_3.value()},
                {5, Colors.TEAL_LIGHTEN_3.value()},
                {6, Colors.PURPLE_LIGHTEN_3.value()}
        };
    }
}
