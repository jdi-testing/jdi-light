package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsFilled extends ICoreElement {

    /**
     * Checks if element is filled or not.
     *
     * @return {@code true} if element is filled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is filled")
    default boolean isFilled() {
        return core().attr("class").contains("--filled");
    }
}
