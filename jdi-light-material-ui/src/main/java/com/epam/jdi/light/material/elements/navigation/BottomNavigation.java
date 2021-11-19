package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.material.asserts.navigation.BottomNavigationAssert;

/**
 * To see an example of Bottom Navigation web element please visit
 * https://material-ui.com/ru/components/bottom-navigation/
 */

public class BottomNavigation extends UIListBase<BottomNavigationAssert> implements IsButton {

    @JDIAction("Is '{name} selected")
    public boolean isSelected() {
        return core().hasClass("Mui-selected");
    }

    @JDIAction("Check if '{name} is not selected")
    public boolean isNotSelected() {
        return !isSelected();
    }

    @Override
    public BottomNavigationAssert is() {
        return new BottomNavigationAssert().set(this);
    }
}
