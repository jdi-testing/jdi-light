package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsClearable extends ICoreElement {

    /**
     * Checks if element is clearable or not.
     *
     * @return {@code true} if element is clearable, otherwise {@code false}
     */
    @JDIAction("Check that {name} is clearable")
    default boolean isClearable() {
        return core().finds(".v-input__icon--clear").size() > 0;
    }
}
