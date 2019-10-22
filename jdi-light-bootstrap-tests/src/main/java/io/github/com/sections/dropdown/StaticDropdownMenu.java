package io.github.com.sections.dropdown;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class StaticDropdownMenu extends Section {
    @UI(".dropdown-item,.dropdown-item-text")
    private WebList items;

    public WebList getItems() {
        return items;
    }

}
