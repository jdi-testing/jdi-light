package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Badge;

/**
 * Interface for getting a {@link Badge} from an element
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
