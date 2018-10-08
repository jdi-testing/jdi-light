package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface Checkbox extends BaseElement, SetValue, HasLabel {
    void check();
    void uncheck();
    boolean isSelected();
}
