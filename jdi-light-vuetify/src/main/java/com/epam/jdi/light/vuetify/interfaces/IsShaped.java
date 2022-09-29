package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsShaped extends ICoreElement {

    /**
     * Checks if element is shaped or not.
     *
     * @return {@code true} if element is shaped, otherwise {@code false}
     */

    @JDIAction("Check that {name} is shaped")
    default boolean isShaped() {
        return core().attr("class").contains("--shaped");
    }
}
