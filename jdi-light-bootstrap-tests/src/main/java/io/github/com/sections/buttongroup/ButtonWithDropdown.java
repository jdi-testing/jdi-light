package io.github.com.sections.buttongroup;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class ButtonWithDropdown extends Section {

    @JDropdown(expand = ".input-group-prepend",
            value = ".dropdown-toggle",
            list = ".dropdown-item")
    public Dropdown dropdownMenu;

    @UI("input") public TextField textInputArea;

    @UI("button") public Button dropdownButton;

}
