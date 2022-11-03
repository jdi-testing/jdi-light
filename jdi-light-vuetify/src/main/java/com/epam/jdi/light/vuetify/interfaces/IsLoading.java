package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>IsLoading</code> includes methods to check that element is loading.
 */
public interface IsLoading extends ICoreElement {

    /**
     * Checks if element is loading or not now.
     *
     * @return {@code true} if element is loading, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is loading")
    default boolean isLoading() {
        return core().attr("class").contains("--is-loading");
    }
}
