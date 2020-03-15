package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;

public interface HasTooltip extends IBaseElement {
    default Tooltip tooltip() {
        return new Tooltip(base());
    }
}
