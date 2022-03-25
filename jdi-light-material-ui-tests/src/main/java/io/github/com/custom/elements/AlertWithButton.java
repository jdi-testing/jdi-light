package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Alert;
import com.epam.jdi.light.ui.html.elements.common.Button;

/**
 * Represents custom alert (with button) MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/alert/">Alert MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class AlertWithButton extends Alert {

    /**
     * Gets this alert's button that hides it.
     *
     * @return collapse button of this alert as {@link Button}
     */
    @JDIAction("Get '{name}' button")
    public Button button() {
        return new Button().setCore(Button.class, core().find(".MuiButtonBase-root"));
    }
}
