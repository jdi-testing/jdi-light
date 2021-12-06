package com.epam.jdi.light.material.interfaces.base;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasImage extends ICoreElement {

    default boolean hasImage() {
        return find("img").isDisplayed() || find("//*[contains(@style, 'background-image')]").isDisplayed();
    }

}
