package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.DividerAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;

/**
 * Represents Divider element on GUI
 *
 * <p>Divider is a component that allows for Material styling of a line separator with various orientation options.</p>
 *
 * @see <a href="https://material.angular.io/components/divider/overview">Divider Overview</a>
 */
public class Divider extends UIBaseElement<DividerAssert> {

    private static final String ORIENTATION_ATTRIBUTE = "aria-orientation";
    private static final String HORIZONTAL_VALUE = "horizontal";

    /**
     * Check whether Divider is horizontal orientation or not
     *
     * @return {@code true} if Divider is horizontal orientation
     */
    @JDIAction("Check if '{name}' is horizontal orientation")
    public boolean isHorizontal() {
        return core().attr(ORIENTATION_ATTRIBUTE).equals(HORIZONTAL_VALUE);
    }

    @Override
    public DividerAssert is() {
        return new DividerAssert().set(this);
    }
}
