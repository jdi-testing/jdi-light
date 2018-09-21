package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.ui.html.common.utility.WithAlt;

public interface Image extends Button, WithAlt {
    default String getSrc() { return getAttribute("src"); }
    default String getHeight() { return getAttribute("height"); }
    default String getWidth() { return getAttribute("width"); }
    default String getValue() { return getSrc(); }
}
