package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class NavbarSimpleLinks extends Navbar {
    @UI(".navbar-brand") public Link brand;
    @UI(".navbar-nav a") public ListGroup listPages;
}
