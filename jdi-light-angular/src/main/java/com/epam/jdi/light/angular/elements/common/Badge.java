package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * To see an example of Badge web element please visit https://material.angular.io/components/badge/overview.
 */

public class Badge extends Text {
    public Badge() { }
    public Badge(ICoreElement core) {
        base().setLocator(".mat-badge-content");
        base().setName(core.getName() + " Badge");
        base().setParent(core);
    }
    public String color() {
        return core().css("background-color");
    }
}
