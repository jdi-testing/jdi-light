package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JAction1;

public interface HasUIElement {
    UIElement core();
    default JDIBase base() {
        return core().base();
    }
}
