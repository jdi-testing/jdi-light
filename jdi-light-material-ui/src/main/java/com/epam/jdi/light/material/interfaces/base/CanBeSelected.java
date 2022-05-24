package com.epam.jdi.light.material.interfaces.base;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface CanBeSelected extends ICoreElement {

    default boolean isSelected() {
        return core().hasClass("Mui-selected");
    }

    default boolean isNotSelected() {
        return !isSelected();
    }
}
