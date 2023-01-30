package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>HasAlignment</code> includes methods to check element alignment.
 */
public interface HasAlignment extends ICoreElement {

    /**
     * Checks if element is located on left side or not.
     *
     * @return {@code true} if element is located on left side, otherwise {@code false}
     */

    @JDIAction("Get if '{name}' has left alignment")
    default boolean hasLeftAlignment() {
        return core().attr("class").contains("--left");
    }

    /**
     * Checks if element is located on right side or not.
     *
     * @return {@code true} if element is located on right side, otherwise {@code false}
     */

    @JDIAction("Get if '{name}' has right alignment")
    default boolean hasRightAlignment() {
        return core().attr("class").contains("--right") ||
                !core().attr("class").contains("--left");
    }
}
