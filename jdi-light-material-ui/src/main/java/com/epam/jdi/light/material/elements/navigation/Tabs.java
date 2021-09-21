package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.material.asserts.navigation.TabsAssert;

/**
 * To see an example of Stepper web element please visit
 * https://mui.com/components/steppers/
 */

public class Tabs extends UIBaseElement<TabsAssert> implements IsButton {

    @Override
    public TabsAssert is() {
        return new TabsAssert().set(this);
    }
}
