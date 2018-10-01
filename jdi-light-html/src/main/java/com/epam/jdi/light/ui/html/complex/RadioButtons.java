package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.ui.html.base.BaseSelector;

public interface RadioButtons extends BaseSelector {
    void select(String value);
    void select(int index);
    String selected();
}
