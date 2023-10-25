package com.epam.jdi.light.angular.elements.enums;

public enum CheckBoxModes {
    BEFORE("before"),
    AFTER("after");
    private final String mode;

    CheckBoxModes(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return this.mode;
    }
}
