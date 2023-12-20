package com.epam.jdi.light.ui.html.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.html.elements.common.Image;

public interface HasImage extends ICoreElement {

    default String imageLocator() {
        return ".//img";
    }
    /**
     * Gets the image of the element.
     *
     * @return image of the element as {@link Image}
     */
    @JDIAction("Get '{name}' image")
    default Image image() {
        return new Image().setCore(Image.class, find(imageLocator()));
    }

    /**
     * Checks that image or background image is displayed.
     *
     * @return {@code true} if the image is displayed, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' image exist")
    default boolean hasImage() {
        return image().isExist();
    }
}
