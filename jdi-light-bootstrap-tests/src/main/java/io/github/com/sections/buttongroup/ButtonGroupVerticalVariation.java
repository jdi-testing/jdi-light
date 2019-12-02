package io.github.com.sections.buttongroup;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class ButtonGroupVerticalVariation extends Section {

    @UI("button[onclick*='Button One']")
    public Button buttonOne;

    @UI("button[onclick*='Button Two']")
    public Button buttonTwo;

    @JDropdown(expand = ".btn-group",
            value = ".dropdown-menu",
            list = ".dropdown-item")
    public Dropdown dropdownMenu;

}
