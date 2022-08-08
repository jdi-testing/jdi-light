package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.BottomNavigationAssert;

/**
 * To see example of Bottom Navigation web element please visit https://vuetifyjs.com/en/components/bottom-navigation/
 */

public class BottomNavigation extends UIListBase<BottomNavigationAssert> {

    protected String buttonListLocator = "//button";

    @Override
    public WebList list() {
        WebList webList = finds(buttonListLocator);
        webList.setStartIndex(getStartIndex());
        return webList;
    }

    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return core().getCssValue("background-color");
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

    @Override
    public BottomNavigationAssert is() {
        return new BottomNavigationAssert().set(this);
    }
}
