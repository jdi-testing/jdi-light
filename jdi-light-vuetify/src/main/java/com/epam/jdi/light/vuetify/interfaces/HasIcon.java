package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.elements.common.Icon;

public interface HasIcon extends ICoreElement {

    default Icon icon() {
        return new Icon().setCore(Icon.class, find("i"));
    }
}
