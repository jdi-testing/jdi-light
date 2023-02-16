package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Alert;

import java.util.List;

public class AlertsPage extends VuetifyPage {

    @UI("#basicAlerts .v-alert")
    public static List<Alert> basicAlerts;

    @UI("#denseAlerts .v-alert")
    public static List<Alert> denseAlerts;

    @UI("#roundedAlert .v-alert")
    public static Alert roundedAlert;

    @UI("#tileAlert .v-alert")
    public static Alert tileAlert;

    @UI("#alertsWithProps .v-alert")
    public static List<Alert> alertsWithProps;

    @UI("#dismissibleAlert > .v-alert")
    public static Alert dismissibleAlert;
    @UI("#dismissibleAlert > .text-center > button")
    public static Button dismissibleAlertResetButton;

    @UI("#prominentAlerts > .error")
    public static Alert prominentErrorAlert;
}
