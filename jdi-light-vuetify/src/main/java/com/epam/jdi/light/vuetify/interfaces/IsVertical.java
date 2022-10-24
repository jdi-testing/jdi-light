package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsVertical extends ICoreElement {

    /**
     * Checks if element is vertical or not.
     *
     * @return {@code true} if element is vertical, otherwise {@code false}
     */
    @JDIAction("Check that {name} is vertical")
    default boolean isVertical() {
        return core().attr("class").contains("--vertical");
    }
}
