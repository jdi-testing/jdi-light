package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Alert;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class AlertWithButton extends Alert {

    @JDIAction("Get '{name}' button")
    public Button button() {
        return new Button().setCore(Button.class, core().find(".MuiButtonBase-root"));
    }

}
