package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.material.asserts.navigation.TabsAssert;

/**
 * To see an example of Tab please visit
 * https://material-ui.com/components/tabs/
 */

public class Tabs extends UIListBase<TabsAssert> implements IsButton {

    @Override
    public TabsAssert is() {
        return new TabsAssert().set(this);
    }

    @JDIAction("Check that {name} is enabled")
    public boolean enabled(int index) {
        return !disabled(index);
    }

    @JDIAction("Check that {name} is disabled")
    public boolean disabled(int index) {
        return list().get(index).hasClass("Mui-disabled");
    }

    @JDIAction("Check that '{0}' is selected")
    public boolean selected(int index) {
        return ((list().get(index).hasClass("Mui-selected")) ? true : false);
    }

    @JDIAction("Check that '{0}' is not selected")
    public boolean notSelected(int index) {
        return !selected(index);
    }
}
