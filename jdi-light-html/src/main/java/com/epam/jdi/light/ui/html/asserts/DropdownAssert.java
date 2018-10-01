package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.ui.html.base.HtmlSelector;
import com.epam.jdi.light.ui.html.complex.Dropdown;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DropdownAssert extends BaseSelectAssert {
    Dropdown dropdown;
    public DropdownAssert(HtmlSelector dropdown) { super(dropdown); this.dropdown = dropdown; }

    public void selected(String option) {
        assertThat(dropdown.selected(), is(option));
    }

}
