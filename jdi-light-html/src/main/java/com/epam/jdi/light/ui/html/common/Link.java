package com.epam.jdi.light.ui.html.common;

import java.net.URL;

public interface Link extends Button {
    String getRef();
    URL getUrl();
    String getAlt();
}
