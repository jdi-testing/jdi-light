package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseFindElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.asserts.RangeAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;
import com.epam.jdi.light.ui.html.base.HtmlElement;

public interface Range extends BaseFindElement<HtmlElement>, HasLabel, SetValue {
    @VerifyValue int volume();
    String max();
    String min();
    String step();
    @FillValue void setVolume(int volume);

    RangeAssert is();
    RangeAssert assertThat();
    RangeAssert has();
    RangeAssert waitFor();
    RangeAssert shouldBe();
    RangeAssert verify();
}
