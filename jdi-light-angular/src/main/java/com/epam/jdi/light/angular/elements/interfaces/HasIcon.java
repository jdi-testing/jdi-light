package com.epam.jdi.light.angular.elements.interfaces;

import com.epam.jdi.light.angular.elements.common.Icon;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Represents an element that has an {@link Icon}.
 */
public interface HasIcon extends ICoreElement {

    String ICON_LOCATOR = ".//mat-icon";

    /**
     * Gets the icon of the element.
     *
     * @return icon of the element as {@link Icon}
     */
    @JDIAction("Get '{name}' icon")
    default Icon icon() {
        return new Icon().setCore(Icon.class, core().find(ICON_LOCATOR));
    }

    /**
     * Checks if element has icon or not.
     *
     * @return {@code true} if element has icon, otherwise {@code false}
     */
    @JDIAction("Get if '{name}' has icon")
    default boolean hasIcon() {
        return icon().isExist() & icon().isVisible();
    }
}
