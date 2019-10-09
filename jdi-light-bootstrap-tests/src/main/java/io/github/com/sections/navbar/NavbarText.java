package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class NavbarText extends Section {
    @UI("/../../nav[1]") public Text simpleNavbar;
    @UI("/../../nav[2]") public Text complexNavbar;
}
