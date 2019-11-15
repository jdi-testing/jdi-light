package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Collapse;

public class NavbarExternalContent extends Navbar {

    @JDropdown(expand = ".navbar-toggler",
            value = ".bg-dark",
            list = ".text-white")
    public Collapse toggler;

    @UI(".text-white") public Text collapsedText;

    @UI(".text-muted") public Text collapsedMutedText;
}
