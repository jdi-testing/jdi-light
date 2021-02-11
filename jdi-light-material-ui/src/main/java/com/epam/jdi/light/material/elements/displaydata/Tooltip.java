package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.asserts.displaydata.TooltipAssert;

public class Tooltip extends UIBaseElement<TooltipAssert> {
    public Tooltip(ICoreElement element) {
        setCore(Tooltip.class, element.core());
    }
}
