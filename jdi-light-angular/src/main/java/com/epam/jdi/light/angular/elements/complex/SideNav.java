package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.webList;

/**
 * To see an example of Checkbox web element please visit https://material.angular.io/components/sidenav/overview.
 */

public class SideNav extends UIBaseElement<UIAssert<?, SideNav>> {

    @JDIAction("Get '{name}' side nav")
    public com.epam.jdi.light.elements.common.uiElement getSideNav() {
        return this.find(".mat-sidenav");
    }

    @JDIAction("Get '{name}' side nav content")
    public com.epam.jdi.light.elements.common.uiElement getContent() {
        return this.find(".mat-sidenav-content");
    }

    /*for several side navs*/
    @JDIAction("Get '{name}' side nav  by '{0}' position value")
    public com.epam.jdi.light.elements.common.uiElement getSideNav(String position) {
        com.epam.jdi.light.elements.common.uiElement element = null;
        for (com.epam.jdi.light.elements.common.uiElement e : getSideNavItems()) {
            if (e.attr("position").equalsIgnoreCase(position)) {
                element = e;
            }
        }
        return element;
    }

    @JDIAction("Get '{name}' side nav content")
    public com.epam.jdi.light.elements.common.uiElement getEvents() {
        return getContent().find(".example-events");
    }

    @JDIAction("Get '{name}' side nav content")
    public webList getSideNavLinks() {
        return getSideNav().finds("a");
    }

    @JDIAction("Get '{name}' side nav content")
    public webList getResponsiveResults() {
        return getContent().finds("p");
    }

    @JDIAction("Get '{name}' side nav items")
    private webList getSideNavItems() {
        return this.finds(".mat-sidenav");
    }

    /*mat-drawer*/
    @JDIAction("Get '{name}' mat drawer")
    public com.epam.jdi.light.elements.common.uiElement getMatDrawer() {
        return this.find(".mat-drawer");
    }

    @JDIAction("Get '{name}' mat drawer content content")
    public com.epam.jdi.light.elements.common.uiElement getMatDrawerContent() {
        return this.find(".mat-drawer-content");
    }
}
