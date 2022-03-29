package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Represents an element that can have error state.
 *
 * @see <a href="https://mui.com/customization/how-to-customize/#state-classes">
 *     State classes MUI Documentation
 *     </a>
 */
public interface HasValidationError extends ICoreElement {

    /**
     * Checks if the element has the error notification or not.
     *
     * @return {@code true} if the element has the error notification, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has the error notification")
    default boolean hasValidationError() {
        return find(".Mui-error").isDisplayed();
    }
}
