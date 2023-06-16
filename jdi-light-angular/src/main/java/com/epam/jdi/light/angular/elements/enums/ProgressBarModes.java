package com.epam.jdi.light.angular.elements.enums;

public enum ProgressBarModes {
    DETERMINATE("determinate"),
    INDETERMINATE("indeterminate"),
    BUFFER("buffer"),
    QUERY("query");

    private final String mode;

    ProgressBarModes(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return this.mode;
    }
}
