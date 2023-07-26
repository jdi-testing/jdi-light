package com.epam.jdi.light.angular.elements.enums;

public enum ChipsColors {
    ACCENT("accent"),
    PRIMARY("primary"),
    WARN("warn");

    private final String color;

    ChipsColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

}
