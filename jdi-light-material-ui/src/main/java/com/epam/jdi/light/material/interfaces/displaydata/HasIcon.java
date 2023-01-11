package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Icon;

/**
 * Represents an element that has an {@link Icon}.
 */
public interface HasIcon extends ICoreElement {

    public String iconLocator = ".MuiSvgIcon-root";
    /**
     * Gets the icon of the element.
     *
     * @return icon of the element as {@link Icon}
     */
    @JDIAction("Get '{name}' icon")
    default Icon icon() {
        return new Icon().setCore(Icon.class, core().find(iconLocator));
    }

    @JDIAction("Is '{name}' has icon")
    default boolean hasIcon() {
        return core().finds(iconLocator).size() > 0;
    }

}
