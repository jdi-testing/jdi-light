package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Represents an element with a placeholder.
 * The placeholder attribute specifies a short hint that describes the expected value of an input field / textarea.
 * The short hint is displayed within the field before the user enters a value.
 *
 * @see <a href="https://www.w3schools.com/tags/att_placeholder.asp#:~:text=The%20placeholder%20attribute%20specifies%20a,the%20user%20enters%20a%20value.">
 *     W3Schools - HTML placeholder Attribute
 *     </a>
 */
public interface HasPlaceholder extends ICoreElement {

    /**
     * Gets the placeholder text of the element.
     *
     * @return placeholder text as {@link String}
     */
    String placeHolderText();
}
