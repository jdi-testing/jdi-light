package com.epam.jdi.light.angular.elements.enums;

public enum ProgressSpinnerModes {
    DETERMINATE("determinate"),
    INDETERMINATE("indeterminate");
    private final String mode;

    ProgressSpinnerModes(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return this.mode;
    }
}
