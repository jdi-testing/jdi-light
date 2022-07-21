package com.epam.jdi.light.vuetify.elements.complex.banners;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;

public class ActionsBanner extends Banner {

    @JDIAction("Get '{name}' control panel")
    public UIElement control() {
        return core().find(".v-input__control");
    }

    @JDIAction("Get '{name}' checkbox")
    public UIElement checkbox() {
        return control().find(".v-input--selection-controls__input");
    }

    @JDIAction("Get '{name}' single line property")
    public UIElement singleLineProperty () {
        return core().find("v-banner--single-line");
    }
}
