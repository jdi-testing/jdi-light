package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.PageAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;

public class Page extends UIBaseElement<PageAssert> implements HasColor {
    public PageAssert is() {
        return new PageAssert().set(this);
    }

}
