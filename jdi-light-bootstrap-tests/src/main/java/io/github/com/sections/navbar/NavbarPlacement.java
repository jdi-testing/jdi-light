package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class NavbarPlacement extends Navbar {

    @UI(".navbar-brand")
    public Link stickyTop;

    @UI(".sticky-top .nav-item")
    public JList navbarLinks;

    @UI("./..")
    public UIElement parentContainer;
}
