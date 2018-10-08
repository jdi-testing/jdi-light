package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface Range extends BaseElement, HasLabel {
    String value();
    String max();
    String min();
    String step();
    void setVolume(String volume);

}
