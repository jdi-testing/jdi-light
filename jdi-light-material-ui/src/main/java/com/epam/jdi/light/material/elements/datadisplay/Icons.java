package com.epam.jdi.light.material.elements.datadisplay;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.datadisplay.IconsAssert;

public class Icons extends UIBaseElement<IconsAssert> {
    @JDIAction("Is {name} visible")
    @Override
    public boolean isDisplayed(){
        return core().isDisplayed();
    }

    @Override
    public IconsAssert is() {
        return new IconsAssert().set(this);
    }
}
