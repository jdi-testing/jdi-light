package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.asserts.ColorAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface ColorPicker extends BaseElement, HasLabel, SetValue {
    @VerifyValue String color();
    @FillValue void setColor(String color);

    ColorAssert is();
    ColorAssert assertThat();

}
