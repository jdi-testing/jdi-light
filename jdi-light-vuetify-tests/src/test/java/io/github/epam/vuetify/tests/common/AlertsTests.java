package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.alertsPage;
import static io.github.com.pages.AlertsPage.blueGreyAlert;
import static io.github.com.pages.AlertsPage.denseErrorAlert;
import static io.github.com.pages.AlertsPage.denseInfoAlert;
import static io.github.com.pages.AlertsPage.denseSuccessAlert;
import static io.github.com.pages.AlertsPage.denseWarningAlert;
import static io.github.com.pages.AlertsPage.dismissibleAlert;
import static io.github.com.pages.AlertsPage.dismissibleAlertResetButton;
import static io.github.com.pages.AlertsPage.errorAlert;
import static io.github.com.pages.AlertsPage.firstIconAlert;
import static io.github.com.pages.AlertsPage.indigoAlert;
import static io.github.com.pages.AlertsPage.infoAlert;
import static io.github.com.pages.AlertsPage.pinkAlert;
import static io.github.com.pages.AlertsPage.purpleOutlinedAlert;
import static io.github.com.pages.AlertsPage.redAlert;
import static io.github.com.pages.AlertsPage.secondIconAlert;
import static io.github.com.pages.AlertsPage.successAlert;
import static io.github.com.pages.AlertsPage.successOutlinedAlert;
import static io.github.com.pages.AlertsPage.thirdIconAlert;
import static io.github.com.pages.AlertsPage.warningAlert;
import static org.hamcrest.Matchers.containsString;


public class AlertsTests extends TestsInit {
    @BeforeMethod
    public void before() {
        alertsPage.open();
        alertsPage.checkOpened();
    }

    @Test
    public void basicAlertsHaveProperTextAndIcon() {
        successAlert.has().text("I'm a success alert.");
        successAlert.getIcon().has().cssClass("mdi-check-circle");

        infoAlert.has().text("I'm an info alert.");
        infoAlert.getIcon().has().cssClass("mdi-information");

        warningAlert.has().text("I'm a warning alert.");
        warningAlert.getIcon().has().cssClass("mdi-exclamation");

        errorAlert.has().text("I'm an error alert.");
        errorAlert.getIcon().has().cssClass("mdi-alert");
    }

    @Test
    public void alertsWithPropsHaveProperCssProps() {
        redAlert.has().text("I'm an alert with a top border and red color");
        redAlert.has().css("background-color", "rgba(229, 115, 115, 1)");
        redAlert.has().cssClass("v-alert--border-top");

        blueGreyAlert.has().text("I'm an alert with a right border and blue-grey color");
        blueGreyAlert.has().css("background-color", "rgba(96, 125, 139, 1)");
        blueGreyAlert.has().cssClass("v-alert--border-right");

        pinkAlert.has().text("I'm an alert with a bottom border and pink color");
        pinkAlert.has().css("background-color", "rgba(216, 27, 96, 1)");
        pinkAlert.has().cssClass("v-alert--border-bottom");

        indigoAlert.has().text("I'm an alert with a border left type info");
        indigoAlert.has().css("background-color", "rgba(63, 81, 181, 1)");
        indigoAlert.has().cssClass("v-alert--border-left");
    }

    @Test
    public void denseAlertsTest() {
        denseInfoAlert.has().text("I'm a dense alert with a type of info");
        denseInfoAlert.getIcon().has().cssClass("mdi-information");

        denseSuccessAlert.has().text("I'm a dense alert with the text prop and a type of success");
        denseSuccessAlert.getIcon().has().cssClass("mdi-check-circle");

        denseWarningAlert.has().text("I'm a dense alert with the border prop and a type of warning");
        denseWarningAlert.getIcon().has().cssClass("mdi-exclamation");

        denseErrorAlert.has().text("I'm a dense alert with the outlined prop and a type of error");
        denseErrorAlert.getIcon().has().cssClass("mdi-alert");
    }

    @Test
    public void dismissibleAlertCouldBeClosed() {
        dismissibleAlert.is().displayed();
        dismissibleAlert.has().text(containsString("Aenean imperdiet. Quisque id odio."));
        dismissibleAlert.getButton().click();

        dismissibleAlert.is().hidden();
        dismissibleAlertResetButton.is().displayed();
        dismissibleAlertResetButton.click();

        dismissibleAlert.is().displayed();
        dismissibleAlert.has().text(containsString("Aenean imperdiet. Quisque id odio."));
    }

    @Test
    public void alertsWithIconHaveProperIcons() {
        firstIconAlert.has().text(containsString("Suspendisse enim turpis, dictum sed"));
        firstIconAlert.getIcon().has().cssClass("mdi-firework");

        secondIconAlert.has().text(containsString("Phasellus blandit leo ut odio. Morbi mattis ullamcorper"));
        secondIconAlert.getIcon().has().cssClass("mdi-material-design");

        thirdIconAlert.has().text(containsString("raesent congue erat at massa. Nullam vel sem."));
        thirdIconAlert.getIcon().has().cssClass("mdi-vuetify");
    }

    @Test
    public void outlinedAlertsHaveProperStyles() {
        String purpleRGBA = "rgba(156, 39, 176, 1)";
        String whiteRGBA = "rgba(0, 0, 0, 0)";

        purpleOutlinedAlert.has().text(containsString("Maecenas ullamcorper, dui et placerat feugiat"));
        purpleOutlinedAlert.has().css("color", purpleRGBA);
        purpleOutlinedAlert.has().css("border-bottom-color", purpleRGBA);
        purpleOutlinedAlert.has().css("border-left-color", purpleRGBA);
        purpleOutlinedAlert.has().css("border-right-color", purpleRGBA);
        purpleOutlinedAlert.has().css("border-top-color", purpleRGBA);
        purpleOutlinedAlert.has().css("background-color", whiteRGBA);

        successOutlinedAlert.has().text(containsString("Aenean commodo ligula"));
    }
}
