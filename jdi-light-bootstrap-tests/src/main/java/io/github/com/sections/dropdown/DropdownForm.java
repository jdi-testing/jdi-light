package io.github.com.sections.dropdown;

import com.epam.jdi.light.ui.bootstrap.elements.complex.Dropdown;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class DropdownForm extends Dropdown {
    @UI("//form") public Form form;
    @UI("#exampleDropdownFormEmail1") public TextField email;
    @UI("#exampleDropdownFormPassword1") public TextField password;
    @UI("//input[@id='dropdownCheck']/..") public Checkbox remember;
    @UI("//form/button") public Button signIn;
}
