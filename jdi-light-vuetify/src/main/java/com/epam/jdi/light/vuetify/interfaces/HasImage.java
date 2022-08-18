package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.elements.common.Image;

/**
 * Represents an element that has an {@link Image}.
 */
public interface HasImage extends ICoreElement {

    /**
     * Gets the image of the element.
     *
     * @return image of the element as {@link Image}
     */
    @JDIAction("Get '{name}' image")
    default Image image() {
        return new Image().setCore(Image.class, core().find("img"));
    }

    /**
     * Checks if element has image or not.
     *
     * @return {@code true} if element has image, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has image")
    default boolean hasImage() {
        return core().finds("img").isNotEmpty();
    }
}
