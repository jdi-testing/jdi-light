package io.github.com.custom;

import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;

import java.lang.reflect.Field;

public class CustomDropdown extends DropdownExpand {
    public CustomDropdown() {
        expandLocator = ".caret";
        valueLocator = ".filter-option";
        listLocator = "li";
    }
    @Override
    public void setup(Field field) { }
}
