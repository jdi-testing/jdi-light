package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Alert;
import io.github.com.custom.AlertWithButton;

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

    // alerts with props section
    @UI("#alertsWithProps > .red")
    public static Alert redAlert;
    @UI("#alertsWithProps > .blue-grey")
    public static Alert blueGreyAlert;
    @UI("#alertsWithProps > .pink")
    public static Alert pinkAlert;
    @UI("#alertsWithProps > .indigo")
    public static Alert indigoAlert;

    // dense alerts
    @UI(".v-alert--dense.info")
    public static Alert denseInfoAlert;
    @UI(".v-alert--dense.success--text")
    public static Alert denseSuccessAlert;
    @UI(".v-alert--dense.warning")
    public static Alert denseWarningAlert;
    @UI(".v-alert--dense.error--text")
    public static Alert denseErrorAlert;

    // dismissible alert
    @UI("#dismissibleAlert > .v-alert")
    public static AlertWithButton dismissibleAlert;
    @UI("#dismissibleAlert > .text-center > button")
    public static Button dismissibleAlertResetButton;

    // alerts with icon
    @UI("#alertsWithIcon > div:nth-child(1)")
    public static Alert firstIconAlert;
    @UI("#alertsWithIcon > div:nth-child(2)")
    public static Alert secondIconAlert;
    @UI("#alertsWithIcon > div:nth-child(3)")
    public static Alert thirdIconAlert;

    // outlined alerts
    @UI("#outlinedAlerts > div:nth-child(1)")
    public static Alert purpleOutlinedAlert;
    @UI("#outlinedAlerts > div:nth-child(2)")
    public static Alert successOutlinedAlert;
    @UI("#outlinedAlerts > div:nth-child(3)")
    public static Alert warningOutlinedAlert;

    // prominent alerts
    @UI("#prominentAlerts > .error")
    public static AlertWithButton prominentErrorAlert;
    @UI("#prominentAlerts > div:nth-child(2)")
    public static Alert prominentSchoolAlert;
    @UI("#prominentAlerts > .info--text")
    public static Alert prominentLockAlert;

    // text alerts
    @UI("#textAlerts > div:nth-child(1)")
    public static AlertWithButton infoTextAlert;
    @UI("#textAlerts > div:nth-child(2)")
    public static Alert fireTextAlert;
    @UI("#textAlerts > div:nth-child(3)")
    public static Alert timeTextAlert;
    @UI("#textAlerts > div:nth-child(4)")
    public static Alert warningTextAlert;

    // transition alert
    @UI("#transitionAlert > .v-alert")
    public static Alert transitionAlert;
    @UI("#transitionAlert > .text-center > button")
    public static Button transitionAlertToggleButton;

}
