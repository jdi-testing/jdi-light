package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.asserts.ImageAssert;

public interface Image extends BaseElement {
    void click();
    String src();
    String height();
    String width();
    String alt();

    ImageAssert is();
    ImageAssert assertThat();

}
