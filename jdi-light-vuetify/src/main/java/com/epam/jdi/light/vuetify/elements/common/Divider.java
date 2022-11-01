package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.DividerAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.HasDirection;

/**
 * To see an example of Divider web element please visit https://vuetifyjs.com/en/components/dividers/
 */

public class Divider extends UIBaseElement<DividerAssert> implements HasDirection, HasTheme {

    @Override
    public DividerAssert is() { return new DividerAssert().set(this); }
}
