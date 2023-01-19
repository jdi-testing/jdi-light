package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>HasTheme</code> includes methods to get element theme.
 */
public interface HasTheme extends ICoreElement {

    /**
     * Get element theme.
     *
     * @return theme value
     */
    @JDIAction("Get '{name}' theme")
    default String theme() {
        return core().classLike("theme--");
    }
}