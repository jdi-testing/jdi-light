package com.epam.jdi.light.ui.html.interfaces.common;

import com.epam.jdi.light.elements.base.BaseFindElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.asserts.NumberAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;
import com.epam.jdi.light.ui.html.base.HtmlElement;

public interface NumberSelector extends BaseFindElement<HtmlElement>, HasLabel, SetValue {
    String placeholder();
    String min();
    String max();
    @VerifyValue String value();
    String step();
    @FillValue void setNumber(String number);

    NumberAssert is();
    NumberAssert assertThat();
    NumberAssert has();
    NumberAssert waitFor();
    NumberAssert shouldBe();
    NumberAssert verify();
}
