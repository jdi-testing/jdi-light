package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.layout.ContainerAssert;

public class Container extends UIBaseElement<ContainerAssert> {

    @JDIAction("Check if {name} width is fixed")
    public boolean fixed() {
        return String.join("", classes()).contains("-fixed");
    }

    @JDIAction("Check if {name} width is fluid")
    public boolean fluid() {
        return !fixed();
    }

    @JDIAction("Get max width of {name}")
    public String getMaxWidth() {
        return css("max-width");
    }

    @Override
    public ContainerAssert is() {
        return new ContainerAssert().set(this);
    }
}
