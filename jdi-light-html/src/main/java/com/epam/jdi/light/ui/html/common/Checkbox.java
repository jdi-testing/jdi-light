package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseFindElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.asserts.CheckboxAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;
import com.epam.jdi.light.ui.html.base.HtmlElement;

public interface Checkbox extends BaseFindElement<HtmlElement>, HasLabel, SetValue {
    void click();
    @FillValue default void check(String value) {
        if (value.equalsIgnoreCase("true") || value.equals("1"))
            check();
        else uncheck();
    }
    void check();
    void uncheck();
    @VerifyValue boolean isSelected();

    CheckboxAssert is();
    CheckboxAssert assertThat();
    CheckboxAssert has();
    CheckboxAssert waitFor();
    CheckboxAssert shouldBe();
    CheckboxAssert verify();
}
