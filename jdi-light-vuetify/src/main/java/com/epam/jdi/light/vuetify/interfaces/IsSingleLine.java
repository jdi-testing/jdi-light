package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>IsSingleLine</code> includes methods to check that element is single line.
 */
public interface IsSingleLine extends ICoreElement {

    /**
     * Checks if element is single line or not.
     *
     * @return {@code true} if element is single line, otherwise {@code false}
     */
    @JDIAction("Get if '{name}' is single line")
    default boolean isSingleLine() {
        return core().attr("class").contains("--single-line");
    }
}
