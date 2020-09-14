package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SideNavAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

/**
 * To see an example of Checkbox web element please visit https://material.angular.io/components/sidenav/overview.
 */

public class SideNav extends UIBaseElement<SideNavAssert> {

    @JDIAction("Get '{name}' side nav")
    public UIElement getSideNav() {
        return this.find(".mat-sidenav");
    }

    @JDIAction("Get '{name}' side nav content")
    public UIElement getContent() {
        return this.find(".mat-sidenav-content");
    }

    /*for several side navs*/
    @JDIAction("Get '{name}' side nav  by '{0}' position value")
    public UIElement getSideNav(String position) {
        UIElement element = null;
        for (UIElement e : getSideNavItems()) {
            if (e.attr("position").equalsIgnoreCase(position)) {
                element = e;
            }
        }
        return element;
    }

    @JDIAction("Get '{name}' side nav content")
    public UIElement getEvents() {
        return getContent().find(".example-events");
    }

    @JDIAction("Get '{name}' side nav content")
    public WebList getSideNavLinks() {
        return getSideNav().finds("a");
    }

    @JDIAction("Get '{name}' side nav content")
    public WebList getResponsiveResults() {
        return getContent().finds("p");
    }

    @Override
    public SideNavAssert is() {
        return new SideNavAssert().set(this);
    }

    @JDIAction("Get '{name}' side nav items")
    private WebList getSideNavItems() {
        return this.finds(".mat-sidenav");
    }
}
