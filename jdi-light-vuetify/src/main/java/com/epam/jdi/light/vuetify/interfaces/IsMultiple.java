package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsMultiple extends ICoreElement {

    /**
     * Checks if element is multiple or not.
     *
     * @return {@code true} if element is multiple, otherwise {@code false}
     */
    @JDIAction("Check that {name} is multiple")
    default boolean isMultiple() {
        return core().attr("class").contains("--is-multi");
    }
}
