package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.DividerAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;

/**
 * To see an example of Divider web element please visit https://material.angular.io/components/divider/overview.
 */

public class Divider extends UIBaseElement<DividerAssert> {
    @Override
    public DividerAssert is() {
        return new DividerAssert().set(this);
    }
}
