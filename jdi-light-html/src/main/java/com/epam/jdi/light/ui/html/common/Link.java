package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.asserts.LinkAssert;

import java.net.URL;

public interface Link extends BaseElement {
    void click();
    String getText();
    String ref();
    URL url();
    String alt();

    LinkAssert is();
    LinkAssert assertThat();
}
