package com.epam.jdi.light.material.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Represents a MUI element which can be disabled on page.
 */
public interface CanBeDisabled extends ICoreElement {

    @Override
    @JDIAction(value = "Check that '{name}' is disabled", timeout = 0)
    default boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @Override
    @JDIAction(value = "Check that '{name}' is enabled", timeout = 0)
    default boolean isEnabled() {
        return !isDisabled();
    }

    /**
     * Checks that element contains other disabled elements or not.
     *
     * @return {@code true} if element contains other disabled elements, otherwise {@code false}
     */
    @JDIAction(value = "Check that '{name}' is enabled", timeout = 0)
    default boolean containsDisabled() {
        return core().find(".Mui-disabled").isDisplayed() || core().attr("class").contains("disabled");
    }
}
