package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsRounded extends ICoreElement {

    /**
     * Checks if element is rounded or not.
     *
     * @return {@code true} if element is rounded, otherwise {@code false}
     */

    @JDIAction("Check that {name} is rounded")
    default boolean isRounded() {
        return core().attr("class").contains("--rounded");
    }
}
