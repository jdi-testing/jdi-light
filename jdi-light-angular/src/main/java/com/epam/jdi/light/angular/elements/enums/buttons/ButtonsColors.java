package com.epam.jdi.light.angular.elements.enums.buttons;

public enum ButtonsColors {

    PRIMARY("rgba(255, 255, 255, 1)"),
    ACCENT("rgba(255, 215, 64, 1)"),
    WARN("rgba(255, 255, 255, 1)");

    private final String color;

    ButtonsColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

}
