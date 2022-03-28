package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

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
