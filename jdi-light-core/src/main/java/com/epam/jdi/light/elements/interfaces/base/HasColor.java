package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.common.JDIAction;

public interface HasColor extends ICoreElement {

    /**
     * Get element color.
     *
     * @return color value
     */

    @JDIAction("Get '{name}'s color")
    default String color() {
        return core().css("color");
    }

    /**
     * Get element background color.
     *
     * @return background color value
     */

    @JDIAction("Get '{name}'s background color")
    default String backgroundColor() {
        return core().css("background-color");
    }
}
