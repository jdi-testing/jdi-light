package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.BottomNavigationAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

/**
 * To see example of Bottom Navigation web element please visit https://vuetifyjs.com/en/components/bottom-navigation/
 */

public class BottomNavigation extends UIListBase<BottomNavigationAssert> implements HasColor, HasTheme, HasMeasurement {

    protected String buttonListLocator = "button";

    @Override
    public WebList list() {
        WebList webList = core().finds(buttonListLocator);
        webList.setStartIndex(getStartIndex());
        return webList;
    }

    @JDIAction("Get '{name}' button color by index")
    public String buttonColor(int index) {
        return list().get(index).getCssValue("color");
    }

    @JDIAction("Get '{name}' button color by text")
    public String buttonColor(String text) {
        return list()
            .stream()
            .filter(uiElement -> uiElement.text().equals(text))
            .findFirst()
            .orElseThrow(RuntimeException::new)
            .getCssValue("color");
    }

    @JDIAction("Get if '{name}' is absolute")
    public boolean isAbsolute() {
        return core().hasClass("v-bottom-navigation--absolute");
    }

    @JDIAction("Get if '{name}' is fixed")
    public boolean isFixed() {
        return core().hasClass("v-bottom-navigation--fixed");
    }

    @JDIAction("Get if '{name}' is grow")
    public boolean isGrow() {
        return core().hasClass("v-bottom-navigation--grow");
    }

    @JDIAction("Get if '{name}' is horizontal")
    public boolean isHorizontal() {
        return core().hasClass("v-bottom-navigation--horizontal");
    }

    @Override
    public BottomNavigationAssert is() {
        return new BottomNavigationAssert().set(this);
    }
}
