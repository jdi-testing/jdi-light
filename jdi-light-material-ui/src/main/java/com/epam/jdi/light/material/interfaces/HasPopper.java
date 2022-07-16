package com.epam.jdi.light.material.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.utils.Popper;

import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * Represents an element that has a {@link Popper}.
 */
public interface HasPopper extends ICoreElement {

    /**
     * Gets the popper of the element.
     *
     * @return popper of the element as {@link Popper}
     */
    @JDIAction("Get '{name}' popper")
    default Popper popper() {
        return new Popper().setCore(Popper.class, $("[role='tooltip']"));
    }
}
