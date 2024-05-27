package com.epam.jdi.light.angular.elements.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface FormField extends ICoreElement {

    /**
     * Checks if element has Error State or not.
     *
     * @return {@code true} if element has Error State, otherwise {@code false}
     */
    @JDIAction("Get if '{name}' is vertical")
    default boolean errorState() {
        return core().hasClass("mat-form-field-invalid");
    }
}
