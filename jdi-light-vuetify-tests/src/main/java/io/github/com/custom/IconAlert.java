package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Alert;

public class IconAlert extends Alert {

    protected static final String DEFAULT_LOCATOR = "i.v-alert__icon";

    @JDIAction("Get icon from '{name}'")
    public UIElement getIcon() {
        return linked(DEFAULT_LOCATOR, String.format("%s.icon", getName()));
    }
}
