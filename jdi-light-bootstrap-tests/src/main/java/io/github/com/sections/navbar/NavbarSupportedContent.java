package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Collapse;
import com.epam.jdi.light.ui.bootstrap.elements.complex.DropdownExpand;

public class NavbarSupportedContent extends Navbar {

    @UI(".navbar-brand")
    public Link brand;

    @JDropdown(root = ".navbar-nav",
            expand = "button[data-toggle=collapse]",
            list = "a")
    public Collapse nav;

    @UI("#navbarDropdown")
    public Link dropdownExpand;

    @JDropdown(root = ".dropdown",
            expand = "#navbarDropdown",
            list = "a")
    public Collapse dropdown;

}
