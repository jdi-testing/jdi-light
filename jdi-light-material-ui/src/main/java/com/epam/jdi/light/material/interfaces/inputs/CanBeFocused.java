package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Represents an element that can be checked to see if it's focused.
 *
 * @see <a href="https://v4.mui.com/customization/how-to-customize/#state-classes">
 *     State classes MUI Documentation
 *     </a>
 */
public interface CanBeFocused extends ICoreElement {

    /**
     * Checks if the element is focused or not.
     *
     * @return {@code true} if the element is focused, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is focused")
    default boolean isFocused() {
        return core().find(".Mui-focused").isDisplayed();
    }
}
