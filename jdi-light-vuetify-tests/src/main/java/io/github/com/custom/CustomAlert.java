package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Alert;

public class CustomAlert extends Alert {

    protected static final String DEFAULT_BUTTON_LOCATOR = "button";

    @JDIAction("Get button from '{name}'")
    public UIElement getButton() {
        return linked(DEFAULT_BUTTON_LOCATOR, String.format("%s.button", getName()));
    }
}
