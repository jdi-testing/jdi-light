package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.elements.common.Icon;

/**
 * Represents an element that has an {@link Icon}
 */
public interface HasIcon extends ICoreElement {

    /**
     * Gets the icon of the element.
     * @return icon of the element as {@link Icon}
     */
    @JDIAction("Get '{name}' icon")
    default Icon icon() {
        return new Icon().setCore(Icon.class, find("i"));
    }
}
