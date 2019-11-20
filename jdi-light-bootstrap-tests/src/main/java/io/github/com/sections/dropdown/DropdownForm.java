package io.github.com.sections.dropdown;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.composite.DropdownMenu;
import io.github.com.sections.form.FormDropdownLogin;

public class DropdownForm extends DropdownMenu {
    @UI("//form")
    public FormDropdownLogin form;
}
