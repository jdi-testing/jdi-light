package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseFindElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.asserts.ColorAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;
import com.epam.jdi.light.ui.html.base.HtmlElement;

public interface ColorPicker extends BaseFindElement<HtmlElement>, HasLabel, SetValue {
    @VerifyValue String color();
    @FillValue void setColor(String color);

    ColorAssert is();
    ColorAssert assertThat();
    ColorAssert has();
    ColorAssert waitFor();
    ColorAssert shouldBe();

}
