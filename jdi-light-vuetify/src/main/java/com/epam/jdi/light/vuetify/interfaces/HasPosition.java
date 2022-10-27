package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasPosition extends ICoreElement {

    /**
     * Checks if element is located on left side or not.
     *
     * @return {@code true} if element is located on left side, otherwise {@code false}
     */

    @JDIAction("Check that {name} has left position")
    default boolean hasLeftPosition() {
        return core().attr("class").contains("--left");
    }

    /**
     * Checks if element is located on right side or not.
     *
     * @return {@code true} if element is located on right side, otherwise {@code false}
     */

    @JDIAction("Check that {name} has right position")
    default boolean hasRightPosition() {
        return core().attr("class").contains("--right");
    }
}
