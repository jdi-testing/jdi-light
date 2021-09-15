package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.alertsPage;
import static io.github.com.pages.AlertsPage.blueGreyAlert;
import static io.github.com.pages.AlertsPage.errorAlert;
import static io.github.com.pages.AlertsPage.indigoAlert;
import static io.github.com.pages.AlertsPage.infoAlert;
import static io.github.com.pages.AlertsPage.pinkAlert;
import static io.github.com.pages.AlertsPage.redAlert;
import static io.github.com.pages.AlertsPage.successAlert;
import static io.github.com.pages.AlertsPage.warningAlert;


public class AlertsTests extends TestsInit {
    @BeforeMethod
    public void before() {
        alertsPage.open();
        alertsPage.checkOpened();
    }

    @Test
    public void basicAlertsHaveProperTextAndIcon(){
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
}
