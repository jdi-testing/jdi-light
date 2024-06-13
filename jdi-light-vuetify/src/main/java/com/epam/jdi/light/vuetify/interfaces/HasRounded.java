package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>HasRounded</code> includes methods to check that element is rounded.
 */
// @todo #5420 Check the all classes has this class if can be rounded
public interface HasRounded extends ICoreElement {

    String ROUNDED_PATTERN = "rounded?[^-0][\\S]*";

    /**
     * Checks if element is rounded or not.
     *
     * @return {@code true} if element is rounded, otherwise {@code false}
     */

    @JDIAction("Get if '{name}' is rounded")
    default boolean isRounded() {
        return element().attr("class").matches(String.format(".*%s.*", ROUNDED_PATTERN));
    }

    /**
     * Get value of rounded.
     *
     * @return rounded value
     */

    @JDIAction("Get '{name}' rounded value")
    default String rounded() {
        return element().classes().stream()
                .filter(cls -> cls.matches(ROUNDED_PATTERN))
                .map(value -> value.replace("rounded-", ""))
                .findFirst()
                .orElse("");
    }

    default String wrapperLocator() {
        return "";
    }

    default UIElement element() {
        if (wrapperLocator().isEmpty()) {
            return core();
        } else {
            return core().find(wrapperLocator());
        }
    }
}
