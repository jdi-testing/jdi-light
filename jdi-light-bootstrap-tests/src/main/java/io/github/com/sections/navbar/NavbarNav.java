package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class NavbarNav extends Section {

//    @UI("//*[contains(@class, 'nav-item')]") public WebList navbarLinks;
//    @UI(".navbar-brand") public Link navbarBrand;
//    @JDropdown(expand = ".navbar-toggler-icon", value = ".navbar-nav", list = "a")
//    public Collapse collapseButton;
//    @UI("//*[contains(@class, 'nav-link dropdown-toggle')]")
//    public Dropdown navbarDropdown;
    @UI("#navbar-nav-with-disabled") public NavbarSimpleLinks navLinks1;
    @UI("#navbar-nav-with-dropdown") public NavbarComplexLinks navbarComplexLinks;
}
