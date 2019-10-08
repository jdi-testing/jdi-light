package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.complex.DropdownExpand;
import org.openqa.selenium.WebElement;

public class NavbarSupportedContent extends Navbar {

    @UI(".navbar-brand")
    public Link brand;

    @JDropdown(root = ".navbar-nav",
            expand = "button[data-toggle=collapse]",
            list = "a")
    public DropdownExpand nav;

}
