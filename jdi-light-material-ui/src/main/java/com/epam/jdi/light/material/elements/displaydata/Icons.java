package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.IconsAssert;

public class Icons extends UIBaseElement<IconsAssert> {
    @JDIAction("Is {name} visible")
    @Override
    public boolean isDisplayed(){
        return core().isDisplayed();
    }

    @JDIAction("Has class '{0}'")
    public boolean hasClass(String className) {
        return core().hasClass(className);
    }

    @Override
    public IconsAssert is() {
        return new IconsAssert().set(this);
    }
}
