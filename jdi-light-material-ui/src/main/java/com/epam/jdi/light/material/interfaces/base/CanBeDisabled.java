package com.epam.jdi.light.material.interfaces.base;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface CanBeDisabled extends ICoreElement {

    default boolean isDisabled() {
        return find(".Mui-disabled").isDisplayed() ||
                attr("class").contains("disabled");
    }

    default boolean isEnabled() {
        return !isDisabled();
    }

}
