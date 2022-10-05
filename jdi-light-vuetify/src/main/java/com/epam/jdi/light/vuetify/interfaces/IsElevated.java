package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsElevated extends ICoreElement {

    /**
     * Checks if element is elevated or not.
     *
     * @return {@code true} if element is elevated, otherwise {@code false}
     */

    @JDIAction("Check that {name} is elevated")
    default boolean isElevated() {
        return core().attr("class").contains("elevation-");
    }

    /**
     * Get value of elevation.
     *
     * @return elevation value
     */

    @JDIAction("Get {name} elevation")
    default int elevation() {
        String elevation = core().classes().stream().filter(cls -> cls.matches("elevation-\\d{1,2}"))
                .findFirst().orElse("");
        return Integer.parseInt(elevation.split("-")[1]);
    }
}
