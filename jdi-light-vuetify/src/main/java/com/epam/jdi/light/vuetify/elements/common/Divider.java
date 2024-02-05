package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.DividerAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.HasOrientation;

/**
 * To see an example of Divider web element please visit https://v2.vuetifyjs.com/en/components/dividers/
 */

public class Divider extends UIBaseElement<DividerAssert> implements HasOrientation, HasTheme {

    @JDIAction("Get if '{name}' is inset")
    public boolean isInset() {
        return core().hasClass("v-divider--inset");
    }

    @Override
    public DividerAssert is() {
        return new DividerAssert().set(this);
    }
}
