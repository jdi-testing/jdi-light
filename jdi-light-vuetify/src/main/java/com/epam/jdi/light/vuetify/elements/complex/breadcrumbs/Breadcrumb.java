package com.epam.jdi.light.vuetify.elements.complex.breadcrumbs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.breadcrumbs.BreadcrumbAssert;

public class Breadcrumb extends UIBaseElement<BreadcrumbAssert> implements IsText {
    @Override
    public BreadcrumbAssert is() {
        return new BreadcrumbAssert().set(this);
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return core().hasClass("v-breadcrumbs__item--disabled");
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isEnabled() {
        return !isDisabled();
    }
}
