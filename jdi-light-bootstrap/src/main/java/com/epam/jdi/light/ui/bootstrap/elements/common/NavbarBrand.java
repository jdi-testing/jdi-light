package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.ui.bootstrap.interfaces.IsNavbarBrand;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public class NavbarBrand extends UIBaseElement<UIAssert> implements IsNavbarBrand, IListBase {
    public boolean isNavbarBrand() {
        return hasClass(".navbar-brand");
    }
}

