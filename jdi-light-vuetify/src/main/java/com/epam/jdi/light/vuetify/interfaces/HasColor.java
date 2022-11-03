package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>HasColor</code> includes methods to check element color and background color.
 */
public interface HasColor extends ICoreElement {

    /**
     * Get element color.
     *
     * @return color value
     */

    @JDIAction("Get '{name}' color")
    default String color() {
        return core().css("color");
    }

    /**
     * Get element background color.
     *
     * @return background color value
     */

    @JDIAction("Get '{name}' background color")
    default String backgroundColor() {
        return core().css("background-color");
    }
}
