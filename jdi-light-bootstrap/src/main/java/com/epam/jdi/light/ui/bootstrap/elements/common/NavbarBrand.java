package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import com.epam.jdi.light.ui.bootstrap.interfaces.IsNavbarBrand;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;


public class NavbarBrand extends UIBaseElement<UIAssert> implements IsNavbarBrand, IListBase {

    @JDIAction(value = "Get '{name}' text", level = DEBUG)
    public String getRef() { return uiElement.attr("href"); }

    @JDIAction(value = "Get '{name}' image alt", level = DEBUG)
    public String getAlt() { return uiElement.attr("alt"); }

    public boolean isLink() {
        return hasAttribute("href");
    };

    public boolean isNavbarBrand() {
        return hasClass(".navbar-brand");
    }
}

