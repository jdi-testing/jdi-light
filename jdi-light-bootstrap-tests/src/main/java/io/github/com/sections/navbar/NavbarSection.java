package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class NavbarSection extends Section {

    //FindBy(css = ".navbar-brand")
    @UI(".navbar-brand")
    public JList<UIElement> allNavbarBrands;

    //FindBy(css = "#brand-as-image,#brand-as-image-and-link")
    @UI("#brand-as-image,#brand-as-image-and-link")
    public JList<UIElement> navbarBrandWithImage;
}
