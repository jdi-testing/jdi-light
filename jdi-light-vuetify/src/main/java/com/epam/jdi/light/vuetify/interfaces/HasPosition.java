package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasPosition extends ICoreElement {

    /**
     * Checks if element is located on left side or not.
     *
     * @return {@code true} if element is located on left side, otherwise {@code false}
     */

    @JDIAction("Check that {name} position is left")
    default boolean isLeft() {
        return core().attr("class").contains("--left");
    }

    /**
     * Checks if element is located on right side or not.
     *
     * @return {@code true} if element is located on right side, otherwise {@code false}
     */

    @JDIAction("Check that {name} position is right")
    default boolean isRight() {
        return core().attr("class").contains("--right");
    }
}
