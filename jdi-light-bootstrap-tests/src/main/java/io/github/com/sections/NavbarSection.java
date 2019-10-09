package io.github.com.sections;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.NavbarBrand;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Navbar;

import java.util.List;

public class NavbarSection extends Navbar {
    @UI(".navbar-grand")
    public List<NavbarBrand> navbarBrandLinkJList;

    @UI(".navbar-grand")
    public List<Link> navbarBrandJList;

}
