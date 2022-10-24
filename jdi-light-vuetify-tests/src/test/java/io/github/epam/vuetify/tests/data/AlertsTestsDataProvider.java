package io.github.epam.vuetify.tests.data;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

public class AlertsTestsDataProvider {

    @DataProvider(name = "basicAlertsTestsData")
    public static Object[][] basicAlertsTestsData() {
        return new Object[][] {
                {1, "I'm a success alert.", "mdi-check-circle"},
                {2, "I'm an info alert.", "mdi-information"},
                {3, "I'm a warning alert.", "mdi-exclamation"},
                {4, "I'm an error alert.", "mdi-alert"}
        };
    }

    @DataProvider(name = "colorAlertsTestsData")
    public static Object[][] colorAlertsTestsData() {
        return new Object[][] {
                {1, Colors.WHITE.value(), Colors.GREEN.value()},
                {2, Colors.WHITE.value(), Colors.BLUE.value()},
                {3, Colors.WHITE.value(), Colors.ORANGE_DARKEN_1.value()},
                {4,Colors.WHITE.value(), Colors.RED_ACCENT_2.value()}
        };
    }

    @DataProvider(name = "dismissibleAlertsTestsData")
    public static Object[][] dismissibleAlertsTestsData() {
        return new Object[][]{
                {"Aenean imperdiet. Quisque id odio."}
        };
    }
}
