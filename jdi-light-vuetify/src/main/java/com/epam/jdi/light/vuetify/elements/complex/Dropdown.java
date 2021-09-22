package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.DropdownAssert;

public class Dropdown extends UIBaseElement<DropdownAssert> {

    @Override
    public DropdownAssert is() {
        return new DropdownAssert().set(this);
    }
}
