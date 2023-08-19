package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface CanBeSelected extends ICoreElement {
    @JDIAction(value = "Check that '{name}' is selected", timeout = 0)
    default boolean isSelected() {
        return core().isSelected();
    }
}
