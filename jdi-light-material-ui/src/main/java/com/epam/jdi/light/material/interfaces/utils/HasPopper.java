package com.epam.jdi.light.material.interfaces.utils;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.utils.Popper;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public interface HasPopper extends ICoreElement {

    default Popper popper() {
        return new Popper().setCore(Popper.class, $("[role='tooltip']"));
    }
}
