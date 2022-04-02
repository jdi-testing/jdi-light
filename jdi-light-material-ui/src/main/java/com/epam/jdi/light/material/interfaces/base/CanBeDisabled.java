package com.epam.jdi.light.material.interfaces.base;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface CanBeDisabled extends ICoreElement {

    default boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    default boolean isEnabled() {
        return !isDisabled();
    }

    default boolean containsDisabled() {
        return find(".Mui-disabled").isDisplayed()
            || attr("class").contains("disabled");
    }

}
