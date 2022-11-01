package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasTheme extends ICoreElement {

    /**
     * Get element theme.
     *
     * @return theme value
     */
    @JDIAction("Get '{name}' color")
    default String theme() {
        return core().classes().stream()
                .filter(value -> value.contains("theme--"))
                .findFirst()
                .get();
    }
}
