package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.displaydata.BadgeAssert;


/**
 * To see an example of Badge web element please visit
 * https://mui.com/components/badges/
 */

public class Badge extends UIBaseElement<BadgeAssert> {

    @JDIAction("Get '{name}' icon")
    public UIElement getIcon() {
        return this.find(".MuiBadge-badge");
    }

    @JDIAction("Get '{name}' icon")
    public String getCounterValue() {
        return this.getIcon().text();
    }

    @JDIAction("Get '{name}' icon")
    public boolean hasDot() {
        return this.getIcon().getAttribute("class").contains("MuiBadge-dot");
    }

    @JDIAction("Get '{name}' icon color status")
    public boolean hasIconStatus(String colorStatus) {
        return this.getIcon().getAttribute("class").contains(colorStatus);
    }

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    @Override
    public BadgeAssert has() {
        return this.is();
    }
}
