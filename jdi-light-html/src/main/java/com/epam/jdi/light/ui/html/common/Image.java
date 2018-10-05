package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.base.ImageAssert;

public interface Image extends BaseElement {
    void click();
    String getSrc();
    String getHeight();
    String getWidth();
    String getAlt();

    ImageAssert is();
    ImageAssert assertThat();

}
