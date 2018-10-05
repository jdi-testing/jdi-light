package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.base.TextAssert;

public interface Text extends BaseElement {
    String getText();

    TextAssert is();
    TextAssert assertThat();
}
