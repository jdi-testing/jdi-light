package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>IsShaped</code> includes methods to check that element is shaped.
 */
public interface IsShaped extends ICoreElement {

    /**
     * Checks if element is shaped or not.
     *
     * @return {@code true} if element is shaped, otherwise {@code false}
     */

    @JDIAction("Get if '{name}' is shaped")
    default boolean isShaped() {
        return core().attr("class").contains("--shaped");
    }
}
