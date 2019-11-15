package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class NavbarContainer extends Navbar {
    @UI("#navbar-containers-centred") public NavbarSimpleLinks navLinks1;
    @UI("#navbar-containers-expanded") public NavbarComplexLinks navbarComplexLinks;
}
