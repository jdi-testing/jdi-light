package com.epam.jdi.light.ui.html.interfaces.complex;
import com.epam.jdi.light.ui.html.base.BaseSelector;

public interface RadioButtons extends BaseSelector {
    void select(String value);
    <TEnum extends Enum> void select(TEnum value);
    void select(int index);
    String selected();
}
