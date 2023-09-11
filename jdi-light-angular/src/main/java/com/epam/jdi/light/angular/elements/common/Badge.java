package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.BadgeAssert;
import com.epam.jdi.light.angular.elements.enums.BadgePosition;
import com.epam.jdi.light.angular.elements.enums.BadgeSize;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import static com.epam.jdi.light.angular.elements.enums.BadgeSize.LARGE;
import static com.epam.jdi.light.angular.elements.enums.BadgeSize.MEDIUM;
import static com.epam.jdi.light.angular.elements.enums.BadgeSize.SMALL;

/**
 * To see an example of Badge web element please visit https://material.angular.io/components/badge/overview.
 */

public class Badge extends UIBaseElement<BadgeAssert> implements IsText {
    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    @JDIAction("Get '{name}' color")
    public String color() {
        return core().css("background-color");
    }

    @Override
    public String getText() {
        return core().getText();
    }
}
