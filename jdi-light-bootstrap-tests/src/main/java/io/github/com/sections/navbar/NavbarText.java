package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class NavbarText extends Section {
    @UI("nav:nth-child(1)") public Text simpleText;
    @UI("nav.navbar.navbar-expand-lg.navbar-light.bg-light") public NavbarTextLinks complexNavbar;
}
