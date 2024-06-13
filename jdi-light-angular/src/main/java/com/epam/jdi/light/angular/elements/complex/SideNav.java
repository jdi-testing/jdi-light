package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SideNaveAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

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

    @JDIAction("Get '{name}' side nav content")
    public WebList getSideNavLinks() {
        return this.finds("a");
    }

    public String getSideNaveText() {
        return core().text();
    }
}
