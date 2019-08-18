package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.Label;

public interface HasLabel extends ICoreElement {
    default Label label() {
        return core().label();
    }
    /**
     * Gets label text
     * @return String text
     */
    @JDIAction("Get '{name}' label text")
    default String labelText() {
        return core().labelText();
    }
}
