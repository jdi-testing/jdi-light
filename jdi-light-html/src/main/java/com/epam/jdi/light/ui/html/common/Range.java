package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.asserts.RangeAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface Range extends BaseElement, HasLabel, SetValue {
    @VerifyValue int volume();
    String max();
    String min();
    String step();
    @FillValue void setVolume(int volume);

    RangeAssert is();
    RangeAssert assertThat();
}
