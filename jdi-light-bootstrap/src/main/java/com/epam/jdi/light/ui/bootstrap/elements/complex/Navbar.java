package com.epam.jdi.light.ui.bootstrap.elements.complex;


import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;

public class Navbar extends Section {

    @UI("//*[contains(@class, 'nav-item')]") public WebList navbarLinks;
    @UI(".navbar-brand") public Link navbarBrand;
    @JDropdown(expand = ".navbar-toggler-icon", value = ".navbar-nav", list = "a")
    public Collapse collapseButton;
    @UI("//*[contains(@class, 'nav-link dropdown-toggle')]")
    public Dropdown navbarDropdown;
}
