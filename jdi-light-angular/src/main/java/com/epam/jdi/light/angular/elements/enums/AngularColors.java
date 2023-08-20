package com.epam.jdi.light.angular.elements.enums;

import java.util.Arrays;

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

    public static AngularColors fromColor(String color) {
        return Arrays.stream(AngularColors.values())
                .filter(c -> c.color.equalsIgnoreCase(color))
                .findFirst()
                .orElse(AngularColors.UNDEFINED);
    }
}
