package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.surfaces.AppBarAssert;

public class AppBar extends UIBaseElement<AppBarAssert> {
    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @JDIAction("Is {name} displayed")
    @Override
    public boolean isDisplayed(){
        return core().isDisplayed();
    }

    public String getValue() {
        return core().getText();
    }

    @Override
    public AppBarAssert is() {
        return new AppBarAssert().set(this);
    }
}
