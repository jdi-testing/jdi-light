package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsSingleLine extends ICoreElement {

    /**
     * Checks if element is single line or not.
     *
     * @return {@code true} if element is single line, otherwise {@code false}
     */
    @JDIAction("Check that {name} is single line")
    default boolean isSingleLine() {
        return core().attr("class").contains("--single-line");
    }
}
