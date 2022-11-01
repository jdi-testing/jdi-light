package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>IsFlat</code> includes methods to check that element is flat.
 */
public interface IsFlat extends ICoreElement {

    /**
     * Checks if element is flat or not.
     *
     * @return {@code true} if element is flat, otherwise {@code false}
     */

    @JDIAction("Check that '{name}' is flat")
    default boolean isFLat() {
        return core().attr("class").contains("--flat");
    }
}
