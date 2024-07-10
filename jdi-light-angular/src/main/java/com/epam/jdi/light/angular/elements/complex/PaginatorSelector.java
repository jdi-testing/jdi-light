package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;

import static org.openqa.selenium.Keys.ESCAPE;

public class PaginatorSelector extends Dropdown {
    @Override
    public void close() {
        if (isExpanded()) {
            press(ESCAPE);
        }
    }

    @Override
    public boolean isExpanded() {
        return expander().attr("aria-expanded").equals("true");
    }
}
