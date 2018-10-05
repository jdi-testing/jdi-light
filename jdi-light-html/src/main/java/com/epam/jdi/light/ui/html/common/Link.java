package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.base.LinkAssert;

import java.net.URL;

public interface Link extends BaseElement {
    void click();
    String getText();
    String getRef();
    URL getUrl();
    String getAlt();

    LinkAssert is();
    LinkAssert assertThat();


}
