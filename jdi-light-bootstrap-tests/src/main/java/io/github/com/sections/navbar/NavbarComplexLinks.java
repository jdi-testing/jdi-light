package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Collapse;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

public class NavbarComplexLinks extends Section {
    @UI(".navbar-brand")
    public Link brand;
    @UI("ul li")
    public ListGroup listPages;

    @JDropdown(root = ".dropdown",
            expand = "#navbarDropdownMenuLink",
            list = "a")
    public Dropdown dropdown;
//    public Collapse dropdown;
}
