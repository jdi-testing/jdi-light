package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class NavbarColorScheme extends Navbar {

    @UI(".navbar-brand")
    public Link navbarLink;

    @ByText("Home")
    public Link homeLink;

    @ByText("Contact form")
    public Link contactFormLink;

    @ByText("Metals & Colors")
    public Link metalsAndColorsLink;

    @UI("form input")
    public TextField searchFormInput;

    @UI("form button")
    public Button searchButton;
}
