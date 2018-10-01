package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.asserts.MultiSelectAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;

import java.util.List;

// Implements Input + Dropdown
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public interface MultiSelect extends BaseElement, SetValue, HasLabel {
    void select(String... values);
    void select(int... indexes);
    List<String> selected();
    List<String> enabled();
    List<String> disabled();

    List<String> values();
    void setValue(String value);
    String getValue();

    MultiSelectAssert is();
    MultiSelectAssert assertThat();
}
