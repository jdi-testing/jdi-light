package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface TextField extends Text, SetValue, HasLabel {
    void sendKeys(CharSequence... value);
    void setText(String value);
    void clear();
    void input(String value);
    void focus();
    String placeholder();

    @Override
    default void setValue(String value) { setText(value); }
}
