package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.navigation.TabsAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;

/**
 * To see an example of Tab please visit
 * https://mui.com/components/tabs/
 */

public class Tabs extends UIListBase<TabsAssert> {

    @Override
    public WebList list() {
        return finds(".MuiTab-root");
    }

    @JDIAction("Returns {name}'s left scroll button")
    public Button leftScroll() {
        return new Button().setCore(Button.class, find("//div[@aria-disabled='false'][1]"));
    }

    @JDIAction("Returns {name}'s right scroll button")
    public Button rightScroll() {
        return new Button().setCore(Button.class, find("//div[@aria-disabled='false'][2]"));
    }

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
