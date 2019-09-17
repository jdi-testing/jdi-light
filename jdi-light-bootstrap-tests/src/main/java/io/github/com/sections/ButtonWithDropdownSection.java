package io.github.com.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ButtonWithDropdown;

public class ButtonWithDropdownSection extends Section {

    public ButtonWithDropdown dropdownMenu;

    @Css("input") public UIElement textInputArea;

    @Css("button") public Button dropdownButton;

}
