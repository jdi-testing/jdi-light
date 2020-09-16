package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

/**
 * To see an example of Badge web element please visit https://material.angular.io/components/badge/overview.
 */

public class Badge extends UIBaseElement<UIAssert<?, Badge>> {

    public UIElement getBadge(){
        return this.find(".mat-badge-content");
    }

}
