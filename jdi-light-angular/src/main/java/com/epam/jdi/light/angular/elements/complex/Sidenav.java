package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SidenavAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

public class Sidenav extends UIBaseElement<SidenavAssert> {

    @Override
    public SidenavAssert is() {
        return new SidenavAssert().set(this);
    }

    @JDIAction("Get '{name}' tabs")
    public WebList getSideNavItems() {
        return this.finds(".mat-sidenav");
    }

    public UIElement getSideNavByContent(String value) {
        UIElement element = null;
        for (UIElement e : getSideNavItems()) {
            if (e.getText().equals(value)) {
                element = e;
            }
        }
        return element;
    }

    public UIElement getSideNavContent(){
        return this.find(".mat-sidenav-content");
    }

}
