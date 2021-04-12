package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.navigation.BottomNavigationAssert;

/**
 * To see an example of Bottom Navigation web element please visit
 * https://material-ui.com/ru/components/bottom-navigation/
 */

public class BottomNavigation extends UIBaseElement<BottomNavigationAssert> {

    @JDIAction("Is '{name} selected")
    public boolean isSelected(){
        return core().hasClass("Mui-selected");
    }

    @Override
    public BottomNavigationAssert is() {
        return new BottomNavigationAssert().set(this);
    }
}
