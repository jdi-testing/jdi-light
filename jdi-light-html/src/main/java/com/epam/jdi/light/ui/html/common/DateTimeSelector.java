package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface DateTimeSelector extends BaseElement, HasLabel {
    String value();
    String min();
    String max();
    void setDateTime(String dateTime);
}
