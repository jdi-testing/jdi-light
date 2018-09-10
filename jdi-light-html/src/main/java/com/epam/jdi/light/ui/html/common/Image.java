package com.epam.jdi.light.ui.html.common;

public interface Image extends Button {
    default String getSrc() { return getAttribute("src"); }
    default String getHeight() { return getAttribute("height"); }
    default String getWidth() { return getAttribute("width"); }
    default String getAlt() { return getAttribute("alt"); }
}
