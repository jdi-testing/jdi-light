package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.feedback.Alert;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.custom.elements.AlertWithButton;

import java.util.List;

public class AlertPage extends WebPage {
    @UI("//h2[text()='Description']/preceding::*[contains(@class, 'MuiAlert-root')]")
    public static List<Alert> basicAlerts;

    @UI("//div[contains(@class, 'MuiTypography-root')]/ancestor::*[contains(@class, 'MuiAlert-root')]")
    public static List<Alert> alertsWithDescription;

    @UI(".MuiCollapse-container")
    public static AlertWithButton alertWithButton;

    @UI(".MuiButton-root")
    public static Button reopenButton;

    @UI("//h2[text()='Icon']/following::*[contains(@class, 'MuiAlert-root')][position()<4]")
    public static List<Alert> alertsWithDifferentIcons;

    @UI("//h2[text()='Variants']/following::*[contains(@class, 'MuiAlert-root')][position()<3]")
    public static List<Alert> outlinedAlerts;

    @UI("//h2[text()='Variants']/following::*[contains(@class, 'MuiAlert-root')][position()>2]")
    public static List<Alert> filledAlerts;

}
