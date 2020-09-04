package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SideNavAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

public class SideNav extends UIBaseElement<SideNavAssert> {

    @JDIAction("Get '{name}' side nav items ")
    public WebList getSideNavItems() {
        return this.finds(".mat-sidenav");
    }

    @JDIAction("Get '{name}' side nav")
    public UIElement getSideNav(){
        return this.find(".mat-sidenav");
    }

    @JDIAction("Get '{name}' side nav content")
    public UIElement getContent(){
        return this.find(".mat-sidenav-content");
    }

    /*two side navs*/
    @JDIAction("Get '{name}' side nav  by '{0} position value'")
    public UIElement getSideNav(String value) {
        UIElement element = null;
        for (UIElement e : getSideNavItems()) {
            if (e.attr("position").equals(value)) {
                element = e;
            }
        }
        return element;
    }

    /*open close events*/
    @JDIAction("Get '{name}' checkbox'")
    public UIElement checkbox(){
        return this.find("mat-checkbox");
    }
    @JDIAction("Get '{name}' toggle button'")
    public UIElement toggleButton(){
        return this.find("button");
    }
    @JDIAction("Get '{name}' events'")
    public WebList openCloseEvents(){
        return this.finds(".example-events");
    }

    /*configurable mode*/
    @JDIAction("Get '{name}' radio buttons'")
    public UIElement sideRadioButtons(){
        return this.getSideNav().find("mat-radio-group");
    }

    @JDIAction("Get '{name}' radio buttons'")
    public UIElement contentRadioButtons(){
        return this.getContent().find("mat-radio-group");
    }





    @Override
    public SideNavAssert is() {
        return new SideNavAssert().set(this);
    }


}
