package com.epam.jdi.light.material.interfaces.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasColor extends ICoreElement {
    @JDIAction("Get '{name}' color")
    default String getColor() {
        return core().getCssValue("color");
    }
}
