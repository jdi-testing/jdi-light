package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Tooltip;

/**
 * Interface for getting a {@link Tooltip} from an element
 */
public interface HasTooltip extends ICoreElement {

    /**
     * Gets the tooltip of element.
     *
     * @return tooltip of element as {@link Tooltip}
     */
    @JDIAction("Get '{name}' tooltip")
    default Tooltip tooltip() {
        return new Tooltip().setCore(Tooltip.class, core());
    }
}
