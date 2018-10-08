package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface ColorPicker extends BaseElement, HasLabel {
    String color();
    void setColor(String color);

}
