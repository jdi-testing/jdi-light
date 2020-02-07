package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class NavbarSupportedContent extends Navbar {

    @UI(".navbar-brand")
    public Link brand;

    @UI("button[data-toggle=collapse]")
    public Button navExpand;

    @UI("input")
    public TextField searchField;

    @UI(".btn-outline-success")
    public Button searchButton;

    @JDropdown(root = ".navbar-nav",
            list = "a")
    public DropdownExpand nav;

    @JDropdown(root = ".dropdown",
            expand = "#navbarDropdown",
            list = "a")
    public DropdownExpand dropdown;

}
