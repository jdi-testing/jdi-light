package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>IsMultiple</code> includes methods to check that element is multiple.
 */
public interface IsMultiple extends ICoreElement {

    /**
     * Checks if element is multiple or not.
     *
     * @return {@code true} if element is multiple, otherwise {@code false}
     */
    @JDIAction("Get if '{name}' is multiple")
    default boolean isMultiple() {
        return core().attr("class").contains("--is-multi");
    }
}
