package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>IsDense</code> includes methods to check that element is dense.
 */
public interface IsDense extends ICoreElement {

    /**
     * Checks if element is dense or not.
     *
     * @return {@code true} if element is dense, otherwise {@code false}
     */
    @JDIAction("Get if '{name}' is dense")
    default boolean isDense() {
        return core().attr("class").contains("--dense");
    }
}
