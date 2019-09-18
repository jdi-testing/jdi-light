package io.github.com.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class ButtonWithDropdown extends Section {

    @JDropdown(expand = ".input-group-prepend",
            value = ".dropdown-toggle",
            list = ".dropdown-item")
    public Dropdown dropdownMenu;

    @Css("input") public UIElement textInputArea;

    @Css("button") public Button dropdownButton;

}
