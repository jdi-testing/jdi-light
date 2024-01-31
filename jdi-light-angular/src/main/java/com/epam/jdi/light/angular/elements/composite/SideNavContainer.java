package com.epam.jdi.light.angular.elements.composite;

import com.epam.jdi.light.angular.asserts.SideNavContainerAssert;
import com.epam.jdi.light.angular.elements.complex.SideNav;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import org.openqa.selenium.Point;

public class SideNavContainer extends UIBaseElement<SideNavContainerAssert> implements HasLabel {


    @Override
    public SideNavContainerAssert is() {
        return new SideNavContainerAssert().set(this);
    }

    @Override
    public SideNavContainerAssert has() {
        return is();
    }

    @JDIAction("Get '{name}' side nav")
    public SideNav getSideNav() {
        return new SideNav().setCore(SideNav.class, this.find(".mat-sidenav"));
    }

    @JDIAction("Get '{name}' side nav content")
    public UIElement getContent() {
        return this.find(".mat-sidenav-content");
    }

    @JDIAction("Get '{name}' side nav content")
    public UIElement getEvents() {
        return getContent().find(".example-events");
    }

    @JDIAction("Get '{name}' side nav content")
    public WebList getResponsiveResults() {
        return getContent().finds("p");
    }

    /*mat-drawer*/
    @JDIAction("Get '{name}' mat drawer")
    public SideNav getMatDrawer() {
        return new SideNav().setCore(SideNav.class, this.find(".mat-drawer"));

    }

    @JDIAction("Get '{name}' mat drawer content content")
    public UIElement getMatDrawerContent() {
        return this.find(".mat-drawer-content");
    }

    @JDIAction("Is '{name}' side nav  has section with location '{0}' on right side")
    public boolean isSectionInRightPart(Point locationOfSection) {
        int containerCenterX = this.getLocation().getX() + this.getSize().getWidth() / 2;
        return locationOfSection.getX() >= containerCenterX;
    }

    /*for several side navs*/
    @JDIAction("Get '{name}' side nav  by '{0}' position value")
    public SideNav getSideNav(String position) {
        UIElement element = null;
        for (UIElement e : getSideNavItems()) {
            if (e.attr("position").equalsIgnoreCase(position)) {
                element = e;
            }
        }
        return new SideNav().setCore(SideNav.class, element);
    }

    @JDIAction("Get '{name}' side nav items")
    private WebList getSideNavItems() {
        return this.finds(".mat-sidenav");
    }
}
