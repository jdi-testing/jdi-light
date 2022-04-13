package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.navigation.TabsAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;

/**
 * Represent tabs MUI component on GUI. Tabs organize and allow navigation between groups of content
 * that are related and at the same level of hierarchy.
 *
 * @see <a href="https://mui.com/components/tabs/">Tabs MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Tabs extends UIListBase<TabsAssert> {

    @Override
    public WebList list() {
        return finds(".MuiTab-root");
    }

    /**
     * Gets the left scroll button.
     *
     * @return left scroll button as {@link Button}
     */
    @JDIAction("Returns {name}'s left scroll button")
    public Button leftScroll() {
        return new Button().setCore(Button.class, find("//div[@aria-disabled='false'][1]"));
    }

    /**
     * Gets the right scroll button.
     *
     * @return right scroll button as {@link Button}
     */
    @JDIAction("Returns {name}'s right scroll button")
    public Button rightScroll() {
        return new Button().setCore(Button.class, find("//div[@aria-disabled='false'][2]"));
    }

    /**
     * Checks if the tab with given index is enabled or not.
     *
     * @return {@code true} if the tab is enabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}'({0}) is enabled")
    public boolean enabled(int index) {
        return !disabled(index);
    }

    /**
     * Checks if the tab with given index is disabled or not.
     *
     * @return {@code true} if the tab is disabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}'({0}) is disabled")
    public boolean disabled(int index) {
        return list().get(index).hasClass("Mui-disabled");
    }

    /**
     * Checks if the tab with given index is selected or not.
     *
     * @return {@code true} if the tab is selected, otherwise {@code false}
     */
    @JDIAction("Check that tab in '{name}' by index '{0}' is selected")
    public boolean selected(int index) {
        return list().get(index).hasClass("Mui-selected");
    }

    @Override
    public TabsAssert is() {
        return new TabsAssert().set(this);
    }
}
