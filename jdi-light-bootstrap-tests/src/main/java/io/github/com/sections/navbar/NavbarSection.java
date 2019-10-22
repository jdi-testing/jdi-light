package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class NavbarSection extends Section {

    //FindBy(css = "#brand-heading")
    @UI("#brand-heading")
    public UIBaseElement navbarBrandHeading;

    //FindBy(css = "#brand-link")
    @UI("#brand-link")
    public UIBaseElement navbarBrandLink;

    //FindBy(css = "#brand-as-image")
    @UI("#brand-as-image")
    public UIBaseElement navbarBrandAsImage;

    //FindBy(css = "#brand-as-image-and-link")
    @UI("#brand-as-image-and-link")
    public UIBaseElement navbarBrandAsImageAndLink;
}
