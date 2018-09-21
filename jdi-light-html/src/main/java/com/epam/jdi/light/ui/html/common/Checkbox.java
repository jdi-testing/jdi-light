package com.epam.jdi.light.ui.html.common;

public interface Checkbox extends Button {
    void check();
    void uncheck();
    boolean isSelected();
    default String getValue() { return isSelected() ? "true" : "false"; }

}
