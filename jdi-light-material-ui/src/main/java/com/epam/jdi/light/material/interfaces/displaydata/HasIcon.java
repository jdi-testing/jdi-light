package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Icon;

public interface HasIcon extends ICoreElement {

    default Icon icon() {
        return new Icon().setCore(Icon.class, find(".MuiSvgIcon-root"));
    }
}