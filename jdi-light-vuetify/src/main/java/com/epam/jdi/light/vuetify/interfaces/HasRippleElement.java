package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>HasRippleElement</code> includes methods to check that html contains ripple elements.
 */
public interface HasRippleElement extends ICoreElement {
    @JDIAction("Get if '{name}' has ripple element")
    default boolean hasRippleElement(String element) {
        return core().jsExecute("outerHTML").contains(element);
    }
}
