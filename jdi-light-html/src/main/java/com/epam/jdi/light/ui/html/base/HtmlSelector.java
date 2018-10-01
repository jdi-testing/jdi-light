package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.ui.html.asserts.DropdownAssert;
import com.epam.jdi.light.ui.html.complex.Combobox;
import com.epam.jdi.light.ui.html.complex.DataList;
import com.epam.jdi.light.ui.html.complex.Dropdown;

public class HtmlSelector extends HtmlBaseSelector implements Dropdown, DataList, Combobox {
    @Override
    public void select(String value) { select().selectByVisibleText(value); }
    public void select(int index) { select().selectByIndex(index); }
    public String selected() { return select().getFirstSelectedOption().getText(); }

    @Override
    public void setValue(String value) { select(value); }
    @Override
    public String getValue() { return selected(); }

    public DropdownAssert is() {
        return new DropdownAssert(this);
    }
    public DropdownAssert assertThat() {
        return is();
    }

}
