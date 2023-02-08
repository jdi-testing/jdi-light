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

    @JDIAction("Get if '{name}' is tile")
    default boolean isTile() {
        String cssStyle = core().attr("class");
        return cssStyle.contains("rounded-0") || cssStyle.contains("--tile");
    }
}
