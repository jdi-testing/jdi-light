package com.epam.jdi.light.material.elements.utils.enums;

public enum TransitionType {
    COLLAPSE("collapse"),
    FADE("fade"),
    GROW("grow"),
    SLIDE("slide"),
    ZOOM("zoom");

    String type;

    public String getType() {
        return type;
    }

    TransitionType(String type) {
        this.type = type;
    }
}
