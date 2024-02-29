package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Represents an element that can have error state.
 *
 * @see <a href="https://v4.mui.com/customization/how-to-customize/#state-classes">
 *     State classes MUI Documentation
 *     </a>
 */
public interface HasValidationError extends ICoreElement {

    /**
     * Checks if the element has the present validation error notification or not.
     *
     * @return {@code true} if the validation error notification is present, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has the error notification")
    default boolean isValidationErrorPresent() {
        return core().find(".Mui-error").isDisplayed();
    }
}
