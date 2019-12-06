package com.epam.jdi.light.ui.bootstrap.elements.complex.navs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class NestedNav extends Section {
    @UI("nav") public ListGroup navGroup;          // @FindBy(css = "nav")
    @UI("nav nav a") public ListGroup navItemLink; // @FindBy(css = "nav nav a")
    @UI(".navbar-brand") public Link navbarLink;   // @FindBy(css = ".navbar-brand")
}
