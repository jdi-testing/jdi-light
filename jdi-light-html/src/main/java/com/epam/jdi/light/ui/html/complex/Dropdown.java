package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.asserts.DropdownAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;

import java.util.List;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface Dropdown extends BaseElement, SetValue, HasLabel {
    void select(String value);
    void select(int index);
    String selected();
    List<String> values();
    void setValue(String value);
    String getValue();
    List<String> enabled();
    List<String> disabled();

    DropdownAssert is();
    DropdownAssert assertThat();
}
