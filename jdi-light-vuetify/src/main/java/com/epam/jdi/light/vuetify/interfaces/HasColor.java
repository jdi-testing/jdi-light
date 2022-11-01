package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

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
