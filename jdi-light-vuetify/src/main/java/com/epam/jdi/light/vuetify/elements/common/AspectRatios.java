package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.AspectRatiosAssert;

/**
 * To see an example of Aspect Ratios please visit "https://vuetifyjs.com/en/components/aspect-ratios/"
 */

public class AspectRatios extends UIBaseElement<AspectRatiosAssert> {
    /**
     * Return ratio value with width and height in double
     *
     * @param width  width value
     * @param height height value
     * @return ratio value in double
     */
    @JDIAction("Ratio of '{name}' has width '{0}' and height '{1}'")
    public static double ratioValue(double width, double height) {
        return width / height;
    }

    public AspectRatiosAssert is() {
        return new AspectRatiosAssert().set(this);
    }

    public AspectRatiosAssert has() {
        return is();
    }
}
