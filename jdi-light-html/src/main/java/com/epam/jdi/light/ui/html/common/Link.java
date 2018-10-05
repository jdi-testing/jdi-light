package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.ui.html.base.LinkAssert;

import java.net.URL;

public interface Link extends Button {
    String getRef();
    URL getUrl();
    String getAlt();

    LinkAssert is();
    LinkAssert assertThat();
}
