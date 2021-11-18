package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
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
    public boolean enabled() {
        return list().isNotEmpty() && list().stream().anyMatch(UIElement::isEnabled)
                && list().stream().anyMatch(UIElement::isClickable);
    }

    @JDIAction("Check that {name} is disabled")
    public boolean disabled() {
        return !enabled();
    }

    @JDIAction("Check that '{0}' is selected")
    public boolean selected(int index) {

        // взять элемент по идексу и проверить класс Mui-selected
        return ((list().get(index).hasClass("Mui-selected")) ? true : false);
    }
}
