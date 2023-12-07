package com.epam.jdi.light.angular.elements.enums;

import java.util.Arrays;

public enum AngularColors {

    PRIMARY("mat-primary", "rgba(103, 58, 183, 1)"),
    ACCENT("mat-accent", "rgba(255, 215, 64, 1)"),
    WARN("mat-warn", "rgba(244, 67, 54, 1)"),
    UNSELECTED("unselected", "rgba(0, 0, 0, 0.54)"),
    DEFAULT("default", "rgba(0, 0, 0, 1)"),
    UNDEFINED("undefined", "rgba(0, 0, 0, 0)");

    private final String styleName;
    private final String color;

    AngularColors(String styleName, String color) {
        this.styleName = styleName;
        this.color = color;
    }

    public String getStyle() {
        return this.styleName;
    }

    public String getColor() {
        return this.color;
    }

    public static AngularColors fromStyle(String styleName) {
        return Arrays.stream(AngularColors.values())
                .filter(c -> c.styleName.equalsIgnoreCase(styleName))
                .findFirst()
                .orElse(AngularColors.UNDEFINED);
    }

    public static AngularColors fromColor(String color) {
        return Arrays.stream(AngularColors.values())
                .filter(c -> c.color.equalsIgnoreCase(color))
                .findFirst()
                .orElse(AngularColors.UNDEFINED);
    }

    public static AngularColors fromName(String name) {
        return Arrays.stream(AngularColors.values())
                .filter(c -> c.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(AngularColors.UNDEFINED);
    }
}
