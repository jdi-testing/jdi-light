package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.utils.PortalAssert;

public class Portal extends UIBaseElement<PortalAssert> {

    @JDIAction("Get {name} {0} field")
    public UIElement field(int num) {
        return finds("//button/following::div").get(num);
    }

    @JDIAction("Get {name} button")
    public UIElement button() {
        return find("button");
    }

    @Override
    public PortalAssert is() {
        return new PortalAssert().set(this);
    }
}
