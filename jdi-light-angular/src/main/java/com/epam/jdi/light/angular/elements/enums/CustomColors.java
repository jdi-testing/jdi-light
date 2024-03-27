package com.epam.jdi.light.angular.elements.enums;

import java.util.Arrays;

public enum CustomColors {

    PURPLE("rgba(103, 58, 183, 1)"),
    YELLOW("rgba(255, 215, 64, 1)"),
    RED("rgba(244, 67, 54, 1)"),
    BLACK_SEMI_TRANSPARENT("rgba(0, 0, 0, 0.54)"),
    BLACK("rgba(0, 0, 0, 1)"),
    TRANSPARENT("rgba(0, 0, 0, 0)");

    private final String color;

    CustomColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public static CustomColors fromColor(String color) {
        return Arrays.stream(CustomColors.values())
                .filter(c -> c.color.equalsIgnoreCase(color))
                .findFirst()
                .orElse(CustomColors.TRANSPARENT);
    }
}
