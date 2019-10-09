package io.github.com.sections;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.NavbarBrand;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Navbar;

import java.util.List;

public class NavbarSection extends Section {
    @UI(".navbar-brand")
    public JList<NavbarBrand> navbarBrandLinkJList;
}
