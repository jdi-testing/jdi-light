package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.navigation.BottomNavigationAssert;

/**
 * To see an example of Accordion web element please visit
 * https://jdi-testing.github.io/jdi-light/material/button_navigation
 */

public class BottomNavigation extends UIBaseElement<BottomNavigationAssert> {

    @JDIAction("Is '{name} selected")
    public boolean isSelected(){
        return core().hasClass("Mui-selected");
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public BottomNavigationAssert is() {
        return new BottomNavigationAssert().set(this);
    }
}
