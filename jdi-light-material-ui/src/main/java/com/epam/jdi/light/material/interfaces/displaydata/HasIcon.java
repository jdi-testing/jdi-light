package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Icon;

/**
 * Represents an element that has an {@link Icon}
 */
public interface HasIcon extends ICoreElement {

    /**
     * Gets the icon of element.
     *
     * @return icon of element as {@link Icon}
     */
    @JDIAction("Get '{name}' icon")
    default Icon icon() {
        return new Icon().setCore(Icon.class, core().find(".MuiSvgIcon-root"));
    }
}
