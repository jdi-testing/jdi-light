package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.utils.PortalAssert;

public class Portal  extends UIBaseElement<PortalAssert> {
    @Override
    public PortalAssert is() {
        return new PortalAssert().set(this);
    }

    public String getValue() {
        return core().getText();
    }
}
