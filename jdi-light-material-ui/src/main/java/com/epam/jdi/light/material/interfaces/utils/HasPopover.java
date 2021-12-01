package com.epam.jdi.light.material.interfaces.utils;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.utils.Popover;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public interface HasPopover extends ICoreElement {

    default Popover popover() {
        return new Popover().setCore(Popover.class, $(".MuiPopover-paper"));
    }
}
