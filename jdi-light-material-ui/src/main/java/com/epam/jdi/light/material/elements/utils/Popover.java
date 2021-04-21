package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.utils.PopoverAssert;

public class Popover extends UIBaseElement<PopoverAssert> {

    @Override
    public PopoverAssert is() {
        return new PopoverAssert().set(this);
    }
}
