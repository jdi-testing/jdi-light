package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;


/**
 * Interface <code>HasStyledText</code> includes methods to check that element has styled text.
 */
public interface HasStyledText extends ICoreElement {

    /**
     * Checks if element has styled text or not.
     *
     * @return {@code true} if element has styled text, otherwise {@code false}
     */

    @JDIAction("Check that '{name}' has styled text")
    default boolean hasStyledText() {
        return core().attr("class").contains("--text");
    }
}
