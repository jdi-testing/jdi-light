package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasValidationError extends ICoreElement {

    @JDIAction("Does '{name}' have error notification")
    default boolean hasValidationError() {
        return find(".Mui-error").isDisplayed();
    }

}
