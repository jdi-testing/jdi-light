package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.BadgeAssert;

public class Badge extends UIBaseElement<BadgeAssert> {

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    @Override
    public BadgeAssert has() {
        return this.is();
    }
}
