package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Represents an element with a placeholder.
 * The placeholder attribute specifies a short hint that describes the expected value of an input field / textarea.
 * The short hint is displayed in the field before the user enters a value.
 *
 * @see <a href="https://www.w3schools.com/tags/att_placeholder.asp#:~:text=The%20placeholder%20attribute%20specifies%20a,the%20user%20enters%20a%20value.">
 *     W3Schools - HTML placeholder Attribute
 *     </a>
 */
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
