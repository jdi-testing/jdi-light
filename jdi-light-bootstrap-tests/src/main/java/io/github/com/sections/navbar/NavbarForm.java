package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class NavbarForm extends Navbar implements PageObject {

    @UI("form") public Form form;
    @UI("input") public TextField textField;
    @UI("button") public Button button;
    @UI("a") public Link textLink;
}
