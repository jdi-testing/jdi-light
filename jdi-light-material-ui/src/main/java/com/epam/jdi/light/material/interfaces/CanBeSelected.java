package com.epam.jdi.light.material.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.HasClick;

/**
 * Represents a MUI element which can be selected on page.
 */
public interface CanBeSelected extends HasClick {

    /**
     * Check whether element is selected or not
     *
     * @return {@code true} if element is selected
     */
    @JDIAction(value = "Check that '{name}' is selected")
    default boolean isSelected() {
        return core().hasClass("Mui-selected");
    }

    /**
     * Check whether element is selected or not
     *
     * @return {@code true} if element is not selected
     */
    default boolean isNotSelected() {
        return !isSelected();
    }
}
