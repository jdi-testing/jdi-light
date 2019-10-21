package io.github.com.sections.navs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

public class NestedNav extends Section {
    @UI("nav") public ListGroup navGroup;          // @FindBy(css = "nav")
    @UI("nav nav a") public ListGroup navItemLink; // @FindBy(css = "nav nav a")
    @UI(".navbar-brand") public Link navbarLink;   // @FindBy(css = ".navbar-brand")
}
