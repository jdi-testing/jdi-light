package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.asserts.DropdownAssert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

import java.util.Arrays;
import java.util.List;

public class Dropdown extends UIBaseElement<DropdownAssert> {
    @UI(".dropdown-toggle")
    private Button dropdownToggle;
    @UI(".dropdown-menu")
    private UIElement dropdownMenu;
    @UI(".dropdown-item,.dropdown-item-text")
    private WebList items;

    @JDIAction("Expand dropdown '{name}' ")
    public void expand() {
        if (isExpanded() == false) {
            dropdownToggle.click();
        }
        waitFor().expanded();
    }

    @JDIAction("Collapse dropdown '{name}' ")
    public void collapse() {
        if (isExpanded() == true) {
            dropdownToggle.click();
        }
        waitFor().collapsed();
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return hasClass("show");
    }

    @JDIAction("Check that '{name}' is collapsed")
    public boolean isCollapsed() {
        return !isExpanded();
    }

    @Override
    public DropdownAssert is() {
        return new DropdownAssert<>().set(this);
    }

    @JDIAction("Select item '{0}' in dropdown '{name}' ")
    public void select(String item) {
        items.select(item);
    }

    @JDIAction("Get values from dropdown '{name}' ")
    public List<String> itemValues() {
        return items.values();
    }

    @JDIAction("Check that values contains {0} in dropdown '{name}' ")
    public boolean hasItems(String... item) {
        return itemValues().containsAll(Arrays.asList(item));
    }

    public WebList list() {
        return this.items;
    }

    public Button expander() {
        return dropdownToggle;
    }

    public UIElement menu() {
        return dropdownMenu;
    }
}
