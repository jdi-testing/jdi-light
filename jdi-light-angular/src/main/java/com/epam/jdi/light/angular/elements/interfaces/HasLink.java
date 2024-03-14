package com.epam.jdi.light.angular.elements.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * In angular element can be with Link, so this interface can be used to work with it
 */
public interface HasLink extends ICoreElement {
    @JDIAction("Get if there is link inside the button")
    default boolean hasLink() {
        return core().hasAttribute("href");
    }

    @JDIAction("Get '{name}' reference")
    default String ref() {
        return core().attr("href");
    }
}
