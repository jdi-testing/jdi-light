package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.IconAssert;

public class Icon extends UIBaseElement<IconAssert> {
    @JDIAction("Is '{name}' displayed")
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @JDIAction("Is '{name}' has correct size")
    public Boolean isSize(String size) {
        return core().hasClass(String.format("MuiSvgIcon-fontSize%s", size));
    }

    @JDIAction("Is '{name}' has correct color")
    public Boolean isColor(String color) {
        return core().hasClass(String.format("MuiSvgIcon-color%s", color));
    }

    @Override
    public IconAssert is() {
        return new IconAssert().set(this);
    }
}
