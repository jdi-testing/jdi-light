package com.epam.jdi.light.angular.elements.enums;

public enum AngularColors {

    PRIMARY("primary"),
    ACCENT("accent"),
    WARN("warn"),

    UNDEFINED("undefined");

    private final String color;

    AngularColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
