package io.github.epam.vuetify.tests.data;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

import static io.github.com.pages.AlertsPage.errorAlert;
import static io.github.com.pages.AlertsPage.infoAlert;
import static io.github.com.pages.AlertsPage.successAlert;
import static io.github.com.pages.AlertsPage.warningAlert;

public class AlertsTestsDataProvider {

    @DataProvider(name = "basicAlertsTestsData")
    public static Object[][] basicAlertsTestsData() {
        return new Object[][] {
                {successAlert, "I'm a success alert.", "mdi-check-circle", "background-color", Colors.GREEN.value()},
                {infoAlert, "I'm an info alert.", "mdi-information", "background-color", Colors.BLUE.value()},
                {warningAlert, "I'm a warning alert.", "mdi-exclamation", "background-color", Colors.ORANGE_DARKEN_1.value()},
                {errorAlert, "I'm an error alert.", "mdi-alert", "background-color", Colors.RED_ACCENT_2.value()}
        };
    }

    @DataProvider(name = "dismissibleAlertsTestsData")
    public static Object[][] dismissibleAlertsTestsData() {
        return new Object[][]{
                {"Aenean imperdiet. Quisque id odio."}
        };
    }
}
