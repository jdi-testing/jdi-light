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

    @JDIAction("Get '{name}' side nav items")
    public WebList getSideNavItems() {
        return this.finds(".mat-sidenav");
    }

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
            if (e.attr("position").equals(position)) {
                element = e;
            }
        }
        return element;
    }

    @Override
    public SideNavAssert is() {
        return new SideNavAssert().set(this);
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

}


//    /*boolean*/
//    @JDIAction("'{name}' has '{0}' text")
//    public boolean navHasText(String text) {
//        return getSideNav().text().equals(text);
//    }
//
//    @JDIAction("'{name}' has '{0}' text")
//    public boolean contentHasText(String text) {
//        return getContent().text().equals(text);
//    }
//
//    @JDIAction("'{name}' is visible")
//    public boolean navIsVisible() {
//        return getSideNav().attr(STYLE).equals(STYLE_VISIBLE);
//    }

/*open close events*/
  /*  @JDIAction("Get '{name}' checkbox")
    public UIElement checkbox() {
        return this.find("mat-checkbox");
    }*/


//    @JDIAction("Get '{name}' radio buttons'")
//    public void clickContentToggleButton() {
//        this.getContent().find("button").click();
//    }

//    @JDIAction("'{name}' is toggled ")
//    public boolean isNavToggled() {
//        clickContentToggleButton();
//        this.base().timer().wait(() -> this.visualValidation(".mat-sidenav"));
//        return getSideNav().attr("style").equals(STYLE_VISIBLE);
//    }

//
//    @JDIAction("Get '{name}' radio buttons")
//    public WebList getNavRadioButtons() {
//        return this.finds("mat-radio-group mat-radio-button");
//    }
//
//    @JDIAction("Get '{name}' radio buttons'")
//    public WebList getContentRadioButtons() {
//        return this.finds("mat-sidenav-content mat-radio-group mat-radio-button");
//    }
//
//    @JDIAction("Get '{name}' radio buttons")
//    public UIElement getNavToggleButton() {
//        return this.getSideNav().find("button");
//    }

//
//    @JDIAction("Get '{name}' radio buttons")
//    public UIElement getContentToggleButton() {
//        return this.getContent().find("button");
//    }
//
//    @JDIAction("Click '{name}' side nav radio button by value '{0}'")
//    public void clickNavRadioButton(String value) {
//        getContentRadioButtons().get(value).click();
//    }
//
//    @JDIAction("Click '{name}' content radio button by value '{0}'")
//    public void clickContentRadioButton(String value) {
//        getContentRadioButtons().get(value).click();
//    }
//
//    @JDIAction("Get '{name}' radio buttons'")
//    public void clickNavToggleButton() {
//        this.getSideNav().find("button").click();
//    }