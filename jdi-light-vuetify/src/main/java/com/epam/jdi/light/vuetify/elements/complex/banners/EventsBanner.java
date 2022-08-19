package com.epam.jdi.light.vuetify.elements.complex.banners;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;

public class EventsBanner extends Banner {

    @JDIAction("Get '{name}' single line property")
    public UIElement singleLineProperty () {
        return core().find("v-banner--single-line");
    }
}
