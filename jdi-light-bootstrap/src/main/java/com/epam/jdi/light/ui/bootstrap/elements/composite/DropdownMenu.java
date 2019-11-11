package com.epam.jdi.light.ui.bootstrap.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.asserts.DropdownMenuAssert;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;

public class DropdownMenu extends BootstrapDropdown {
    @UI(".dropdown-item,.dropdown-item-text")
    private WebList items;

    @JDIAction("Select item '{0}' in dropdown menu '{name}' ")
    public void select(int index) {
        items.select(index);
    }

    @JDIAction("Select item '{0}' in dropdown menu '{name}' ")
    public void select(String item) {
        items.select(item);
    }

    @JDIAction("Get values from dropdown menu '{name}' ")
    public List<String> itemValues() {
        return items.values();
    }

    @JDIAction("Check that values contains {0} in dropdown menu '{name}' ")
    public boolean hasItems(String... item) {
        return itemValues().containsAll(Arrays.asList(item));
    }

    public WebList list() {
        return this.items;
    }

    @Override
    public DropdownMenuAssert is() {
        return new DropdownMenuAssert<>().set(this);
    }

    @Override
    public DropdownMenuAssert assertThat() {
        return is();
    }

    @Override
    public DropdownMenuAssert has() {
        return is();
    }

    @Override
    public DropdownMenuAssert waitFor() {
        return is();
    }

    @Override
    public DropdownMenuAssert shouldBe() {
        return is();
    }

    @Override
    public DropdownMenuAssert verify() {
        assertSoft();
        return is();
    }

}
