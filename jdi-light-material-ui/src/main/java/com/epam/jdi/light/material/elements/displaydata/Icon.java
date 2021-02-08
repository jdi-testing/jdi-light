package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.IconAssert;

public class Icon extends UIBaseElement<IconAssert> {
    @JDIAction("Is '{name}' displayed")
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @JDIAction("Is '{name}' large")
    public Boolean isLarge() {
        return core().hasClass("MuiSvgIcon-fontSizeLarge");
    }

    @JDIAction("Is '{name}' small")
    public Boolean isSmall() {
        return core().hasClass("MuiSvgIcon-fontSizeSmall");
    }

    @JDIAction("Is '{name}' inherit")
    public Boolean isInherit() {
        return core().hasClass("MuiSvgIcon-fontSizeInherit");
    }

    @Override
    public IconAssert is() {
        return new IconAssert().set(this);
    }
}
