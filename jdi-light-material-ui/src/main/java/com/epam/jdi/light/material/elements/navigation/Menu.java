package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.navigation.MenuAssert;

/**
 * To see an example of Menu web element please visit
 * https://mui.com/components/menus/
 */

public class Menu extends UIBaseElement<MenuAssert> {

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @JDIAction("Right click '{name}'")
    public void rightClick() {
        core().rightClick();
    }

    @JDIAction("Scroll down")
    public void scrollToElement() {
        core().jsExecute("scrollIntoView()");
    }

    @Override
    public MenuAssert is() {
        return new MenuAssert().set(this);
    }

    @JDIAction("Check if '{name}' is displayed")
    @Override
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @Override
    public MenuAssert has() {
        return this.is();
    }

    @JDIAction("Check text in '{name}'")
    public String getText() {
        return core().getText();
    }
}
