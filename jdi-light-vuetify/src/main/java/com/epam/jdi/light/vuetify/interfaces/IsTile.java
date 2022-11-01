package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>IsTile</code> includes methods to check that element is tile.
 */
public interface IsTile extends ICoreElement {

    /**
     * Checks if element is tile or not.
     *
     * @return {@code true} if element is tile, otherwise {@code false}
     */

    @JDIAction("Check that '{name}' is tile")
    default boolean isTile() {
        return core().attr("class").contains("rounded-0")
                || core().attr("class").contains("--tile");
    }
}
