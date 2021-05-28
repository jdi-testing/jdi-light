package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Tooltip;

public interface HasTooltip extends ICoreElement {
    default Tooltip tooltip() {
        return new Tooltip(core().find("//div[contains(@class,'MuiTooltip-popper')]"));
    }
}
