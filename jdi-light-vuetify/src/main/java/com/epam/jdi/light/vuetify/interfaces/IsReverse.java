package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsReverse extends ICoreElement {

    /**
     * Checks if element is reverse or not.
     *
     * @return {@code true} if element is reverse, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is reverse")
    default boolean isReverse() {
        return core().attr("class").contains("--reverse");
    }
}
