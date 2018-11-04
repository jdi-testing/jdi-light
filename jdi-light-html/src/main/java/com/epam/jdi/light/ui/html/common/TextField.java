package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface TextField extends Text, HasLabel, SetValue {
    void sendKeys(CharSequence... value);
    void setText(String value);
    void clear();
    @FillValue void input(String value);
    void focus();
    String placeholder();
    @VerifyValue String getText();
    default String getValue() {
        return placeholder();
    }
}
