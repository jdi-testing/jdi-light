package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface NumberSelector extends BaseElement, HasLabel {
    String placeholder();
    String min();
    String max();
    String value();
    String step();
    void setNumber(String number);
}
