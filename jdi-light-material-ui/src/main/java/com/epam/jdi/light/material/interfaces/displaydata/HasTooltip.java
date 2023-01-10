package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Tooltip;

import static com.epam.jdi.light.elements.init.JDITalk.NAME_TO_ELEMENT;

/**
 * Represents an element that has an {@link Tooltip}.
 */
public interface HasTooltip extends ICoreElement {

    default String tooltipLocator() {
        return ".MuiTooltip-popper";
    }
    /**
     * Gets the tooltip of the element.
     *
     * @return tooltip of the element as {@link Tooltip}
     */
    @JDIAction("Get '{name}' tooltip")
    default Tooltip tooltip() {
        return new Tooltip().setCore(Tooltip.class, NAME_TO_ELEMENT.execute(this.tooltipLocator()));
    }
}
