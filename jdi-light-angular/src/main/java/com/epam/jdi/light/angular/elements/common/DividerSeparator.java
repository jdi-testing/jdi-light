package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.DividerSeparatorAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;

public class DividerSeparator extends UIBaseElement<DividerSeparatorAssert> {

    private static final String ORIENTATION_ATTRIBUTE = "aria-orientation";
    private static final String HORIZONTAL_VALUE = "horizontal";
    private static final String VERTICAL_VALUE = "vertical";
    private static final String INSET_CLASS = "mat-divider-inset";

    /**
     * Check whether Divider separator is horizontal orientation or not
     *
     * @return {@code true} if Divider separator is horizontal orientation
     */
    @JDIAction("Check if '{name}' is horizontal orientation")
    public boolean isHorizontal() {
        return core().attr(ORIENTATION_ATTRIBUTE).equals(HORIZONTAL_VALUE);
    }

    /**
     * Check whether Divider separator is vertical orientation or not
     *
     * @return {@code true} if Divider separator is vertical orientation
     */

    @JDIAction("Check if '{name}' is vertical orientation")
    public boolean isVertical() {
        return core().attr(ORIENTATION_ATTRIBUTE).equals(VERTICAL_VALUE);
    }

    /**
     * Check whether Divider separator has inset or not
     *
     * @return {@code true} if Divider separator has inset
     */
    @JDIAction("Check if '{name}' has inset")
    public boolean hasInset() {
        return core().hasClass(INSET_CLASS);
    }

    @Override
    public DividerSeparatorAssert is() {
        return new DividerSeparatorAssert().set(this);
    }

    @Override
    public DividerSeparatorAssert has() {
        return new DividerSeparatorAssert().set(this);
    }
}