package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.BottomNavigationAssert;

/**
 * To see example of Bottom Navigation web element please visit https://vuetifyjs.com/en/components/bottom-navigation/
 */

public class BottomNavigation extends UIBaseElement<BottomNavigationAssert> {

    protected String buttonListLocator = "//button";

    public WebList buttonList() {
        return finds(buttonListLocator);
    }

    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return core().getCssValue("background-color");
    }

    public UIElement button(int index) {
        return buttonList().get(index);
    }

    @JDIAction("Get '{name}' button color by index")
    public String buttonColor(int index) {
        return buttonList().get(index).getCssValue("color");
    }

    @Override
    public BottomNavigationAssert is() {
        return new BottomNavigationAssert().set(this);
    }
}
