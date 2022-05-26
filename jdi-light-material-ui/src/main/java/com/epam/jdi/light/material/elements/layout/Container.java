package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.layout.ContainerAssert;

/**
 * To see an example of Container web element please visit
 * https://mui.com/components/container/
 */

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
    public int getMaxWidth() {
        String maxWidth = css("max-width");
        return Integer.parseInt(maxWidth.substring(0, maxWidth.indexOf("px")));
    }

    @Override
    public ContainerAssert is() {
        return new ContainerAssert().set(this);
    }
}
