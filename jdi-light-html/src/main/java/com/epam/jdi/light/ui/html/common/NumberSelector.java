package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.asserts.NumberAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface NumberSelector extends BaseElement, HasLabel, SetValue {
    String placeholder();
    String min();
    String max();
    @VerifyValue String value();
    String step();
    @FillValue void setNumber(String number);

    NumberAssert is();
    NumberAssert assertThat();
}
