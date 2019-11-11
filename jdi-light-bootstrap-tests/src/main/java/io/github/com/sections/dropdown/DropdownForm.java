package io.github.com.sections.dropdown;

import com.epam.jdi.light.ui.bootstrap.elements.complex.Dropdown;
import io.github.com.sections.form.FormDropdownLogin;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class DropdownForm extends Dropdown {
    @UI("//form") public FormDropdownLogin form;
}
