package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface ProgressBar extends BaseElement, HasLabel {
    String value();
    String max();

}
