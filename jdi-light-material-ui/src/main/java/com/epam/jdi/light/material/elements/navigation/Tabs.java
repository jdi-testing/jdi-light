package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.navigation.TabsAssert;

public class Tabs extends UIBaseElement<TabsAssert> {

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public TabsAssert is() {
        return new TabsAssert().set(this);
    }

    @JDIAction("Check text in '{name}'")
    public String getText() {
        return core().getText();
    }
}
