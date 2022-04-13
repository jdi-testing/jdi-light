package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Badge;

/**
 * Represents an element that has a {@link Badge}.
 */
public interface HasBadge extends ICoreElement {

    /**
     * Gets the badge of the element.
     *
     * @return badge of the element as {@link Badge}
     */
    @JDIAction("Get '{name}' badge")
    default Badge badge() {
        return new Badge().setCore(Badge.class, core().find(".MuiBadge-badge"));
    }
}
