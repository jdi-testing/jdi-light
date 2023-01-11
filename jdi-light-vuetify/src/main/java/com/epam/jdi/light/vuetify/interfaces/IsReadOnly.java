package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>IsReadOnly</code> includes methods to check that element is read only.
 */
public interface IsReadOnly extends ICoreElement {

    /**
     * Checks if element is readonly or not.
     *
     * @return {@code true} if element is readonly, otherwise {@code false}
     */

    @JDIAction("Check that '{name}' is readonly")
    default boolean isReadOnly() {
        return core().attr("class").contains("-readonly");
    }
}
