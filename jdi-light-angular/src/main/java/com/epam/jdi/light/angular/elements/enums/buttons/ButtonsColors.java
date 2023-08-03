package com.epam.jdi.light.angular.elements.enums.buttons;

public enum ButtonsColors {

    PRIMARY("primary"),
    ACCENT("accent"),
    WARN("warn");

    private final String color;

    ButtonsColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

}
