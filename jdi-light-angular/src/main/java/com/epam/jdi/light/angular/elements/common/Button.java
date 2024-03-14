package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ButtonAssert;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.angular.elements.enums.ButtonsTypes;
import com.epam.jdi.light.angular.elements.interfaces.HasBadge;
import com.epam.jdi.light.angular.elements.interfaces.IsButton;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.jdiai.tools.map.MapArray;

public class Button extends UIBaseElement<ButtonAssert> implements HasBadge, HasClick, IsText, IsButton {

    private static final String LABEL_LOCATOR = ".mdc-button__label";

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return core().find(LABEL_LOCATOR)
                .text();
    }

    @Override
    public ButtonAssert is() {
        return new ButtonAssert().set(this);
    }
}
