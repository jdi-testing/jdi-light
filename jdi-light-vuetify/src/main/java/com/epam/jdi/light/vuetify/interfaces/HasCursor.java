package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>HasCursor</code> includes methods to get cursor type.
 */
public interface HasCursor extends ICoreElement {

    @JDIAction("Get '{name}' cursor type")
    default String getCursorType() {
        return core().getCssValue("cursor");
    }
}
