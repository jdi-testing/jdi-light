package io.github.com.sections;

import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class ButtonGroup extends Section {

    @Css(".btn-group .btn-danger")
    public static Button redButton;

    @Css(".btn-group .btn-success:not(.dropdown-toggle)")
    public static Button greenButton;

    @Css(".dropdown-toggle")
    public static DropdownExpand dropdownButton;

    @Css(".btn-group .btn-success:not(.dropdown-toggle)")
    public static Button cyanButton;

    @Css(".btn-group .btn-success:not(.dropdown-toggle)")
    public static Button disabledButton;
}