package io.github.com.sections;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.NavbarBrand;

public class NavbarSection extends Section {
    //3 vs 4
    //@FindBy(css = ".navbar-brand")
    @UI(".navbar-brand")
    public JList<NavbarBrand> navbarBrandJList1;

    //3 vs 4
    @UI("a.navbar-brand,span.navbar-brand")
    public JList<NavbarBrand> navbarBrandJList2;

    //3 vs 4
    @UI("#brand-heading,#brand-link,#brand-as-image,#brand-as-image-and-link")
    public JList<NavbarBrand> navbarBrandJList3;

    //3 vs 3
    @UI("#brand-heading,#brand-link,#brand-as-image")
    public JList<NavbarBrand> navbarBrandJList5;

    //3 vs 3
    @UI("#brand-as-image-and-link,#brand-as-image,#brand-heading")
    public JList<NavbarBrand> navbarBrandJList4;

    //3 vs 4
    @UI("#brand-as-image-and-link,#brand-as-image,#brand-heading,#brand-link")
    public JList<NavbarBrand> navbarBrandJList7;

    //1 vs 1
    @UI("#brand-as-image-and-link")
    public JList<NavbarBrand> navbarBrandJList8;

    //1 vs 1
    @UI("#brand-link")
    public JList<NavbarBrand> navbarBrandJList;
}
