package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.asserts.CheckboxAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface Checkbox extends BaseElement, HasLabel, SetValue {
    void click();
    @FillValue
    default void check(String value) {
        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("1"))
            check();
        else uncheck();
    }
    void check();
    void uncheck();
    @VerifyValue boolean isSelected();

    CheckboxAssert is();
    CheckboxAssert assertThat();
}
