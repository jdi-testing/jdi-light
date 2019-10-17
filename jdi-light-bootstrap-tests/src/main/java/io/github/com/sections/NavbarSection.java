package io.github.com.sections;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.NavbarBrand;

public class NavbarSection extends Section {

    //FindBy(css = ".navbar-brand")
    @UI(".navbar-brand")
    public JList<NavbarBrand> allNavbarBrands;

    //FindBy(css = "#brand-as-image,#brand-as-image-and-link")
    @UI("#brand-as-image,#brand-as-image-and-link")
    public JList<NavbarBrand> navbarBrandWithImage;
}
