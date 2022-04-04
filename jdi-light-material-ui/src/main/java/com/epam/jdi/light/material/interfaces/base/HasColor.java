package com.epam.jdi.light.material.interfaces.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Represents an element whose color can be read.
 */
public interface HasColor extends ICoreElement {

    /**
     * Gets the color of the element in form like "rgba(120, 1, 60, 0.52)".
     *
     * @return color value as {@link String}
     */
    @JDIAction("Get '{name}' color")
    default String color() {
        return core().css("color");
    }
}
