package com.epam.jdi.light.material.interfaces.base;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.html.elements.common.Image;

public interface HasImage extends ICoreElement {

    default Image image() {
        return new Image().setCore(Image.class, find("img"));
    }

    default boolean hasImage() {
        return find("img").isDisplayed() || find("//*[contains(@style, 'background-image')]").isDisplayed();
    }
}
