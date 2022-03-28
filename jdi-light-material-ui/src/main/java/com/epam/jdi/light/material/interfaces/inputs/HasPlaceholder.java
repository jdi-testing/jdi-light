package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasPlaceholder extends ICoreElement {

    /**
     * Checks if the element has the placeholder or not.
     *
     * @return {@code true} if the element has the placeholder, otherwise {@code false}
     */
    boolean hasPlaceholder();

    /**
     * Gets the placeholder text of the element as a string.
     *
     * @return placeholder text as {@link String}
     */
    String getPlaceHolderText();
}
