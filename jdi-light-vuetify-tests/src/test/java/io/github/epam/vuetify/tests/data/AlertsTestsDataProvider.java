package io.github.epam.vuetify.tests.data;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

import static io.github.com.pages.AlertsPage.errorAlert;
import static io.github.com.pages.AlertsPage.infoAlert;
import static io.github.com.pages.AlertsPage.successAlert;
import static io.github.com.pages.AlertsPage.warningAlert;
import static io.github.com.pages.AlertsPage.prominentErrorAlert;
import static io.github.com.pages.AlertsPage.prominentSchoolAlert;
import static io.github.com.pages.AlertsPage.prominentLockAlert;
import static io.github.com.pages.AlertsPage.denseInfoAlert;
import static io.github.com.pages.AlertsPage.denseSuccessAlert;
import static io.github.com.pages.AlertsPage.denseWarningAlert;
import static io.github.com.pages.AlertsPage.denseErrorAlert;
import static io.github.com.pages.AlertsPage.purpleOutlinedAlert;
import static io.github.com.pages.AlertsPage.successOutlinedAlert;
import static io.github.com.pages.AlertsPage.warningOutlinedAlert;
import static io.github.com.pages.AlertsPage.redAlert;
import static io.github.com.pages.AlertsPage.blueGreyAlert;
import static io.github.com.pages.AlertsPage.pinkAlert;
import static io.github.com.pages.AlertsPage.indigoAlert;


public class AlertsTestsDataProvider {

    @DataProvider(name = "basicAlertsTestsData")
    public static Object[][] basicAlertsTestsData() {
        return new Object[][] {
                {successAlert, "I'm a success alert.", "mdi-check-circle", "background-color", Colors.GREEN.value(), null},
                {infoAlert, "I'm an info alert.", "mdi-information", "background-color", Colors.BLUE.value(), null},
                {warningAlert, "I'm a warning alert.", "mdi-exclamation", "background-color", Colors.ORANGE_DARKEN_1.value(), "shaped"},
                {errorAlert, "I'm an error alert.", "mdi-alert", "background-color", Colors.RED_ACCENT_2.value(), "elevation"}
        };
    }

    @DataProvider(name = "dismissibleAlertsTestsData")
    public static Object[][] dismissibleAlertsTestsData() {
        return new Object[][]{
                {"Aenean imperdiet. Quisque id odio."}
        };
    }

    @DataProvider(name = "prominentAlertsTestsData")
    public static Object[][] prominentAlertsTestsData() {
        return new Object[][]{
                {prominentErrorAlert, "error", "mdi-alert"},
                {prominentSchoolAlert, "blue-grey", "mdi-school"},
                {prominentLockAlert, "info--text", "mdi-shield-lock-outline"}
        };
    }

    @DataProvider(name = "denseAlertsTestsData")
    public static Object[][] denseAlertsTestsData() {
        return new Object[][]{
                {denseInfoAlert, "I'm a dense alert with a type of info", "mdi-information", "background-color", Colors.BLUE.value()},
                {denseSuccessAlert, "I'm a dense alert with the text prop and a type of success", "mdi-check-circle", "caret-color", Colors.GREEN_RGB.value()},
                {denseWarningAlert, "I'm a dense alert with the border prop and a type of warning", "mdi-exclamation", "background-color", Colors.ORANGE_DARKEN_1.value()},
                {denseErrorAlert, "I'm a dense alert with the outlined prop and a type of error", "mdi-alert", "caret-color", Colors.RED_ACCENT_2_RGB.value()}
        };
    }

    @DataProvider(name = "outlinedAlertsTestsData")
    public static Object[][] outlinedAlertsTestsData() {
        return new Object[][]{
                {purpleOutlinedAlert,"purple--text", "caret-color", Colors.PURPLE_RGB.value()},
                {successOutlinedAlert, "success--text", "caret-color", Colors.GREEN_RGB.value()},
                {warningOutlinedAlert, "warning--text", "caret-color", Colors.ORANGE_DARKEN_1_RGB.value()}
        };
    }

    @DataProvider(name = "borderAlertsTestsData")
    public static Object[][] borderAlertsTestsData() {
        return new Object[][]{
                {redAlert, "I'm an alert with a top border and red color", "top", "background-color", Colors.RED_LIGHTEN_2.value()},
                {blueGreyAlert, "I'm an alert with a right border and blue-grey color", "right", "background-color", Colors.BLUE_GREY.value()},
                {pinkAlert, "I'm an alert with a bottom border and pink color", "bottom","background-color", Colors.PINK_DARKEN_1.value()},
                {indigoAlert, "I'm an alert with a border left type info", "left", "background-color", Colors.INDIGO.value()}
        };
    }

    @DataProvider(name = "transitionAlertsTestsData")
    public static Object[][] transitionAlertsTestsData() {
        return new Object[][]{
                {"style", "display: none;", "TOGGLE"}
        };
    }
}
