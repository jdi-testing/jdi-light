package io.github.com.custom.elements;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.feedback.Alert;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class AlertWithButton extends Alert {

    @UI(".MuiButtonBase-root")
    public Button button;

}
