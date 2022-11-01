package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsOutlined extends ICoreElement {

    /**
     * Checks if element is outlined or not.
     *
     * @return {@code true} if element is outlined, otherwise {@code false}
     */

    @JDIAction("Check that '{name}' is outlined")
    default boolean isOutlined() {
        return core().attr("class").contains("--outlined");
    }
}
