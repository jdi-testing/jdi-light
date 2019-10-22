package io.github.com.sections.dropdown;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Dropdown;

public class DropdownMenuItemsSection extends Section {

    @UI("#dropdown-menu-items")
    //@FindBy(css = "#dropdown-menu-items")
    private Dropdown dropdown;

    @UI("#dropdown-menu-text-item")
    //@FindBy(css = "#dropdown-menu-text-item")
    private StaticDropdownMenu menuWithText;

    public Dropdown getDropdown() {
        return dropdown;
    }

    public StaticDropdownMenu getMenuWithText() {
        return menuWithText;
    }

}
