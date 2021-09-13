package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.alertsPageLink;
import static io.github.com.StaticSite.vuetifyPage;
import static io.github.com.sections.BasicAlerts.errorAlert;
import static io.github.com.sections.BasicAlerts.infoAlert;
import static io.github.com.sections.BasicAlerts.successAlert;
import static io.github.com.sections.BasicAlerts.warningAlert;


public class AlertTests extends TestsInit {
    @BeforeMethod
    public void before() {
        vuetifyPage.open();
        alertsPageLink.click();
    }

    @Test
    public void test(){
        successAlert.is().text("I'm a success alert.");
        successAlert.getIcon().has().cssClass("mdi-check-circle");

        infoAlert.is().text("I'm an info alert.");
        infoAlert.getIcon().has().cssClass("mdi-information");

        warningAlert.is().text("I'm a warning alert.");
        warningAlert.getIcon().has().cssClass("mdi-exclamation");

        errorAlert.is().text("I'm an error alert.");
        errorAlert.getIcon().has().cssClass("mdi-alert");
    }
}
