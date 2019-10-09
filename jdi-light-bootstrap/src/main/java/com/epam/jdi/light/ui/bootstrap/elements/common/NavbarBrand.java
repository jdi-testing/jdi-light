package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.bootstrap.interfaces.IsNavbarBrand;

public class NavbarBrand extends UIBaseElement<UIAssert> implements IsNavbarBrand {
    public boolean isNavbarBrand() {
        return hasClass(".navbar-brand");
    }
}

