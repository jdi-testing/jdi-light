package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>IsRounded</code> includes methods to check that element is rounded.
 */
public interface IsRounded extends ICoreElement {

    /**
     * Checks if element is rounded or not.
     *
     * @return {@code true} if element is rounded, otherwise {@code false}
     */

    @JDIAction("Check that '{name}' is rounded")
    default boolean isRounded() {
        return core().attr("class").matches(".*rounded[^-0]*[-\\\\w]*.*");
    }
}
