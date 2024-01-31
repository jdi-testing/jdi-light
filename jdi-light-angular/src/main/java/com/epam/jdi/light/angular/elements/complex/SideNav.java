package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SideNaveAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import org.openqa.selenium.Point;

/**
 * To see an example of Checkbox web element please visit https://material.angular.io/components/sidenav/overview.
 */

public class SideNav extends UIBaseElement<SideNaveAssert> implements HasLabel {

    @Override
    public SideNaveAssert is() {
        return new SideNaveAssert().set(this);
    }

    @Override
    public SideNaveAssert has() {
        return is();
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
    public WebList getSideNavLinks() {
        return this.finds("a");
    }

    @JDIAction("Get '{name}' side nav items")
    private WebList getSideNavItems() {
        return this.finds(".mat-sidenav");
    }

    @JDIAction("Is '{name}' side nav  has section with location '{0}' on right side")
    public boolean isSectionInRightPart(Point locationOfSection) {
        int containerCenterX = this.getLocation().getX() + this.getSize().getWidth() / 2;
        return locationOfSection.getX() >= containerCenterX;
    }

    public String getSideNaveText() {
        return core().text();
    }
}
