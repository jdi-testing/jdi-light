package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasSize extends ICoreElement {

    /**
     * Get element height.
     *
     * @return height value
     */

    @JDIAction("Get {name}'s height")
    default int height() {
        return core().getSize().getHeight();
    }

    /**
     * Get element width.
     *
     * @return width value
     */

    @JDIAction("Get {name}'s width")
    default int width() {
        return core().getSize().getHeight();
    }
}
