package com.epam.jdi.light.material.interfaces.utils;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.utils.Popover;

import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * Represents an element that has a {@link Popover}.
 */
public interface HasPopover extends ICoreElement {

    /**
     * Gets the popover of the element.
     *
     * @return popover of the element as {@link Popover}
     */
    default Popover popover() {
        return new Popover().setCore(Popover.class, $(".MuiPopover-paper"));
    }
}
