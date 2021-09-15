package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Alert;
import io.github.com.custom.IconAlert;

/**
 * To see an example of Alert web element please visit https://vuetifyjs.com/en/components/alerts/
 */
public class AlertsPage extends WebPage {
    // basic alerts section
    @UI(".success")
    public static IconAlert successAlert;
    @UI(".info")
    public static IconAlert infoAlert;
    @UI(".warning")
    public static IconAlert warningAlert;
    @UI(".error")
    public static IconAlert errorAlert;

    // alerts with props section
    @UI("#alertsWithProps > .red")
    public static Alert redAlert;
    @UI("#alertsWithProps > .blue-grey")
    public static Alert blueGreyAlert;
    @UI("#alertsWithProps > .pink")
    public static Alert pinkAlert;
    @UI("#alertsWithProps > .indigo")
    public static Alert indigoAlert;
}
