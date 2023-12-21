package com.epam.jdi.light.material.interfaces;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasSize extends ICoreElement {

    default boolean isSmall() {
        return core().find("//*[contains(@class, 'SizeSmall')]").isDisplayed()
            || core().attr("class").contains("SizeSmall");
    }

    default boolean isLarge() {
        return core().find("//*[contains(@class, 'SizeLarge')]").isDisplayed()
            || core().attr("class").contains("SizeLarge");
    }

}
