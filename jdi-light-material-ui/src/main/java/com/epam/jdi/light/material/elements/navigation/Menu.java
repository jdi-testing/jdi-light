package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.navigation.MenuAssert;

public class Menu extends UIBaseElement<MenuAssert> {

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @JDIAction("Scroll down")
    public void scrollToElement() {
        core().jsExecute("scrollIntoView()");
    }

    @Override
    public MenuAssert is() {
        return new MenuAssert().set(this);
    }

    @Override
    public boolean isDisplayed() {
        return core().isDisplayed();
    }
}
