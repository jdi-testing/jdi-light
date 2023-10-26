package com.epam.jdi.light.angular.elements.enums;

public enum CheckBoxAlignPosition {
    BEFORE("before"),
    AFTER("after");
    private final String alignPosition;

    CheckBoxAlignPosition(String alignPosition) {
        this.alignPosition = alignPosition;
    }

    public String getAlignPosition() {
        return this.alignPosition;
    }
}
