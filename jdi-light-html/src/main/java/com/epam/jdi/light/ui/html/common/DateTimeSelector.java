package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.asserts.DateTimeAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface DateTimeSelector extends BaseElement, HasLabel, SetValue {
    @VerifyValue String value();
    String min();
    String max();
    @FillValue void setDateTime(String dateTime);

    DateTimeAssert is();
    DateTimeAssert assertThat();
}
