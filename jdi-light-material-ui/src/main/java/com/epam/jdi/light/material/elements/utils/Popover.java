package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.utils.PopoverAssert;
import org.openqa.selenium.By;


public class Popover extends UIBaseElement<PopoverAssert> {

    @JDIAction("Get '{name}' text content")
    public String getText() {
        return this.firstChild().getText();
    }

    @Override
    public PopoverAssert is() {
        return new PopoverAssert().set(this);
    }
}
