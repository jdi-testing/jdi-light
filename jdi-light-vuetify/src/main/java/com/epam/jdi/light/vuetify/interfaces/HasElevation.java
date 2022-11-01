package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import org.apache.commons.lang3.StringUtils;

/**
 * Interface <code>HasElevation</code> includes methods to check element elevation.
 */
public interface HasElevation extends ICoreElement {

    String elevationPattern = "elevation-\\d{1,2}";

    /**
     * Checks if element is elevated or not.
     *
     * @return {@code true} if element is elevated, otherwise {@code false}
     */

    @JDIAction("Check that '{name}' is elevated")
    default boolean isElevated() {
        return core().attr("class").matches(String.format(".*%s.*", elevationPattern));
    }

    /**
     * Get value of elevation.
     *
     * @return elevation value
     */

    @JDIAction("Get '{name}' elevation")
    default String elevation() {
        return core().classes().stream()
                .filter(cls -> cls.matches(elevationPattern))
                .map(value -> value.split("-")[1])
                .findFirst()
                .orElse("");
    }
}
