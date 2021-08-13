package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.navigation.BreadcrumbAssert;

/**
 * To see an example of a Breadcrumbs web element, please visit
 * https://material-ui.com/components/breadcrumbs/
 */

public class Breadcrumb extends UIBaseElement<BreadcrumbAssert> {

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public BreadcrumbAssert is() {
        return new BreadcrumbAssert().set(this);
    }

    @JDIAction("Check if '{name}' is displayed")
    @Override
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    public BreadcrumbAssert has() {
        return this.is();
    }

    @JDIAction("Check text in '{name}'")
    public String getText() {
        return core().getText();
    }
}
