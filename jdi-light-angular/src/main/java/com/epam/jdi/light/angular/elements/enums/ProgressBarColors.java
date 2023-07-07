package com.epam.jdi.light.angular.elements.enums;

public enum ProgressBarColors {
    BLUE("mat-primary"),
    YELLOW("mat-accent"),
    RED("mat-warn"),
    ACCENT("Accent"),
    PRIMARY("Primary"),
    WARN("Warn");

    private final String color;

    ProgressBarColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
