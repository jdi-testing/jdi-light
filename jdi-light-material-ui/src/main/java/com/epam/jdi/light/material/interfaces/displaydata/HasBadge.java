package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Badge;

/**
 * Represents an element that has an {@link Badge}
 */
public interface HasBadge extends ICoreElement {

    /**
     * Gets the badge of element.
     *
     * @return badge of element as {@link Badge}
     */
    default Badge badge() {
        return new Badge().setCore(Badge.class, find(".MuiBadge-badge"));
    }
}
