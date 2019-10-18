package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Collapse;

import java.util.List;

public class NavbarPlacement extends Section {

    @UI(".navbar-brand")
    public Link stickyTop;

    @UI(".sticky-top .nav-item")
    public WebList navbarLinks;


}
