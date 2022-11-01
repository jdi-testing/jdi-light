package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsTextStyled extends ICoreElement {

    /**
     * Checks if element is text or not.
     *
     * @return {@code true} if element is text, otherwise {@code false}
     */

    @JDIAction("Check that '{name}' is text")
    default boolean isTextStyled() {
        return core().attr("class").contains("--text");
    }
}
