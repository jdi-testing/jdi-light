package com.epam.jdi.light.material.interfaces.base;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Represents an element which can be disabled on page.
 */
public interface CanBeDisabled extends ICoreElement {

    @Override
    default boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @Override
    default boolean isEnabled() {
        return !isDisabled();
    }

    /**
     * Checks that element contains other disabled elements or not.
     *
     * @return {@code true} if element contains other disabled elements, otherwise {@code false}
     */
    default boolean containsDisabled() {
        return find(".Mui-disabled").isDisplayed() || attr("class").contains("disabled");
    }
}
