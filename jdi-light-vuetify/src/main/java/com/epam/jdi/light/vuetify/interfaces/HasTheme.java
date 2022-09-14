package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasTheme extends ICoreElement {
    /**
     * Checks if element has light theme.
     *
     * @return {@code true} if element has light theme, otherwise {@code false}
     */
    @JDIAction("Check that {name} has light theme")
    default boolean isLightTheme() {
        return core().hasClass("theme--light");
    }

    /**
     * Checks if element has dark theme.
     *
     * @return {@code true} if element has dark theme, otherwise {@code false}
     */
    @JDIAction("CCheck that {name} has dark theme")
    default boolean isDarkTheme() {
        return core().hasClass("theme--dark");
    }
}
