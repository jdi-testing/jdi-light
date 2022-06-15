package com.epam.jdi.light.material.interfaces.utils;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.utils.enums.Position;

public interface HasPosition extends ICoreElement {

    default Position position(String position) {
        return Position.fromString(position);
    }

}
