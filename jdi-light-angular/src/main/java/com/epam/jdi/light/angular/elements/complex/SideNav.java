package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SideNavAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;


public class SideNav extends UIBaseElement<SideNavAssert> {

    public static final String STYLE_VISIBLE = "transform: none; visibility: visible;";
    public static final String STYLE = "style";

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

    /*two side navs*/
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

    /*open close events*/
    @JDIAction("Get '{name}' checkbox")
    public UIElement checkbox() {
        return this.find("mat-checkbox");
    }

    /*configurable mode*/
    @JDIAction("Get '{name}' radio buttons")
    public WebList getNavRadioButtons() {
        return this.finds("mat-radio-group mat-radio-button");
    }

    @JDIAction("Get '{name}' radio buttons'")
    public WebList getContentRadioButtons() {
        return this.finds("mat-sidenav-content mat-radio-group mat-radio-button");
    }

    @JDIAction("Get '{name}' radio buttons")
    public UIElement getNavToggleButton() {
        return this.getSideNav().find("button");
    }

    @JDIAction("Get '{name}' radio buttons")
    public UIElement getContentToggleButton() {
        return this.getContent().find("button");
    }

    @JDIAction("Click '{name}' side nav radio button by value '{0}'")
    public void clickNavRadioButton(String value) {
        getContentRadioButtons().get(value).click();
    }

    @JDIAction("Click '{name}' content radio button by value '{0}'")
    public void clickContentRadioButton(String value) {
        getContentRadioButtons().get(value).click();
    }

    @JDIAction("Get '{name}' radio buttons'")
    public void clickNavToggleButton() {
        this.getSideNav().find("button").click();
    }

    @JDIAction("Get '{name}' radio buttons'")
    public void clickContentToggleButton() {
        this.getContent().find("button").click();
    }

    @Override
    public SideNavAssert is() {
        return new SideNavAssert().set(this);
    }

    /*boolean*/
    @JDIAction("'{name}' is toggled ")
    public boolean isNavToggled() {
        clickContentToggleButton();
        this.base().timer().wait(() -> this.visualValidation(".mat-sidenav"));
        return getSideNav().attr("style").equals(STYLE_VISIBLE);
    }

    @JDIAction("'{name}' has '{0}' text")
    public boolean navHasText(String text) {
        return this.getSideNav().text().equals(text);
    }

    @JDIAction("'{name}' has '{0}' text")
    public boolean contentHasText(String text) {
        return this.getContent().text().equals(text);
    }

    @JDIAction("'{name}' is visible")
    public boolean navIsVisible() {
        return this.getSideNav().attr(STYLE).equals(STYLE_VISIBLE);
    }

    /*two sides side nav*/
    @JDIAction("'{name}' is visible")
    public boolean startNavIsVisible() {
        UIElement startSideNav = this.getSideNav("start");
        return this.getSideNav().attr(STYLE).equals(STYLE_VISIBLE);
    }
}
