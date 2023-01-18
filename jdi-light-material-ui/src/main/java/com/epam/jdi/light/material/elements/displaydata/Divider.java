package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.DividerAssert;

/**
 * Represents divider MUI component on GUI
 *
 * @see <a href="https://mui.com/components/dividers">Divider MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Divider extends UIBaseElement<DividerAssert> {

    @Override
    public DividerAssert is() {
        return new DividerAssert().set(this);
    }

    /**
     * Checks if the divider is inset or not.
     *
     * @return {@code true} if the divider is inset, otherwise {@code false}
     */
    @JDIAction("Check if '{name}' is inset")
    public boolean isInset() {
        return core().hasClass("MuiDivider-inset");
    }

    /**
     * Checks if the divider is vertical or not.
     *
     * @return {@code true} if the divider is vertical, otherwise {@code false}
     */
    @JDIAction("Check if '{name}' is vertical")
    public boolean isVertical() {
        return core().hasClass("MuiDivider-vertical");
    }
}
