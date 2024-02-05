package com.epam.jdi.light.angular.elements.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>HasOrientation</code> includes methods to check element orientation.
 */
public interface HasOrientation extends ICoreElement {

    /**
     * Checks if element is vertical or not.
     *
     * @return {@code true} if element is vertical, otherwise {@code false}
     */
    @JDIAction("Get if '{name}' is vertical")
    default boolean isVertical() {
        return core().attr("class").contains("-vertical");
    }
}
