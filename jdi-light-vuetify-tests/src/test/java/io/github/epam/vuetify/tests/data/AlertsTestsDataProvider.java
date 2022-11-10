package io.github.epam.vuetify.tests.data;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

public class AlertsTestsDataProvider {

    @DataProvider(name = "textAlertsTestsData")
    public static Object[][] textAlertsTestsData() {
        return new Object[][]{
                {1, "I'm a success alert."},
                {2, "I'm an info alert."},
                {3, "I'm a warning alert."},
                {4, "I'm an error alert."}
        };
    }

    @DataProvider(name = "colorAlertsTestsData")
    public static Object[][] colorAlertsTestsData() {
        return new Object[][]{
                {1, Colors.WHITE.value(), Colors.GREEN.value()},
                {2, Colors.WHITE.value(), Colors.BLUE.value()},
                {3, Colors.WHITE.value(), Colors.ORANGE_DARKEN_1.value()},
                {4, Colors.WHITE.value(), Colors.RED_ACCENT_2.value()}
        };
    }

    @DataProvider(name = "borderAlertsTestsData")
    public static Object[][] borderAlertsTestsData() {
        return new Object[][]{
                {1, "top"},
                {2, "right"},
                {3, "bottom"},
                {4, "left"}
        };
    }

    @DataProvider(name = "typeAlertsTestsData")
    public static Object[][] typeAlertsTestsData() {
        return new Object[][]{
                {1, "success"},
                {2, "info"},
                {3, "warning"},
                {4, "error"}
        };
    }
}
