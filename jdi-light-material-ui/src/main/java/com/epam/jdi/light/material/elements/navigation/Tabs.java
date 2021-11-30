package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.material.asserts.navigation.TabsAssert;

/**
 * To see an example of Tab please visit
 * https://material-ui.com/components/tabs/
 */

public class Tabs extends UIListBase<TabsAssert> {

    @JDIAction("Check that '{name}' is enabled")
    public boolean enabled(int index) {
        return !disabled(index);
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean disabled(int index) {
        return list().get(index).hasClass("Mui-disabled");
    }

    @JDIAction("Check that tab in '{name}' by index'{0}' is selected")
    public boolean selected(int index) {
        return list().get(index).hasClass("Mui-selected");
    }

    @Override
    public TabsAssert is() {
        return new TabsAssert().set(this);
    }
}
