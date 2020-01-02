package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class NavbarSection extends Navbar {

    //FindBy(css = "#brand-heading")
    @UI("#brand-heading")
    public UIElement navbarBrandHeading;

    //FindBy(css = "#brand-link")
    @UI("#brand-link")
    public UIElement navbarBrandLink;

    //FindBy(css = "#brand-as-image")
    @UI("#brand-as-image")
    public UIElement navbarBrandAsImage;

    //FindBy(css = "#brand-as-image-and-link")
    @UI("#brand-as-image-and-link")
    public UIElement navbarBrandAsImageAndLink;
}
