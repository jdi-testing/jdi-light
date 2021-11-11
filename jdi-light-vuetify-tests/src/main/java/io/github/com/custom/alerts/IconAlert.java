package io.github.com.custom.alerts;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Alert;
import com.epam.jdi.light.vuetify.elements.common.Icon;

public class IconAlert extends Alert {

    @UI(".v-alert__icon")
    protected Icon icon;

    public Icon icon() {
        return icon;
    }
}
