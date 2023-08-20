package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.IconAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;

public class Icon extends UIBaseElement<IconAssert> implements HasClick {
    // TODO implement. Done for button
    public String type() {
        return attr("data-mat-icon-type");
    }
}
