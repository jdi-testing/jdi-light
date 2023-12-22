package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;

/**
 * Interface <code>IsClearable</code> includes methods to check existence
 * and interact with element clear button.
 */
public interface IsClearable extends ICoreElement {

    /**
     * Checks if element is clearable or not.
     *
     * @return {@code true} if element is clearable, otherwise {@code false}
     */
    @JDIAction("Get if '{name}' is clearable")
    default boolean isClearable() {
        return core().finds(clearButtonLocator()).size() > 0;
    }

    /**
     * Get clear button
     *
     * @return clear button
     */
    @JDIAction("Get '{name}' clear button")
    default VuetifyButton clearButton() {
        return new VuetifyButton(core().find(clearButtonLocator()));
    }

    /**
     * Get clear button locator
     *
     * @return clear button locator
     */
    default String clearButtonLocator() {
        return ".v-input__icon--clear button";
    }
}
