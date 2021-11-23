package com.epam.jdi.light.material.interfaces.base;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasColor extends ICoreElement {

    default boolean hasPrimaryColor() {
        return core().find("//*[contains(@class, 'colorPrimary')]").isDisplayed();
    }

    default boolean hasSecondaryColor() {
        return core().find("//*[contains(@class, 'colorSecondary')]").isDisplayed();
    }

    default boolean hasColor(String color) {
        return core().getCssValue("background-color").equals(color);
    }
}
