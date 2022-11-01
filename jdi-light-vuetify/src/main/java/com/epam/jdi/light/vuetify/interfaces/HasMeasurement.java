package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasMeasurement extends ICoreElement {

    /**
     * Get element's height.
     *
     * @return height value
     */

    @JDIAction("Get '{name}' height")
    default int height() {
        return core().getSize().getHeight();
    }

    /**
     * Get element's width.
     *
     * @return width value
     */

    @JDIAction("Get '{name}' width")
    default int width() {
        return core().getSize().getWidth();
    }
}
