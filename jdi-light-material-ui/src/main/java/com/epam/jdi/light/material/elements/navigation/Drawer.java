package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.navigation.DrawerAssert;

public class Drawer extends UIBaseElement<DrawerAssert> {

    // This method uses in other tests. Can be deleted in future
    @JDIAction("Check if '{name}' is displayed")
    @Override
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @Override
    public DrawerAssert is() {
        return new DrawerAssert().set(this);
    }
}
