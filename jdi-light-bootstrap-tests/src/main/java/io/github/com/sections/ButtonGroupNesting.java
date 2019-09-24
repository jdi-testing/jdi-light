package io.github.com.sections;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class ButtonGroupNesting extends Section {

    @UI("//button[text()='1']") public Button one;
    @UI("//button[text()='2']") public Button two;
    @JDropdown(expand = ".btn-group",
            value = ".dropdown-menu",
            list = ".dropdown-item")
    public Dropdown dropdownMenu;

}
