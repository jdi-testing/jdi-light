package io.github.com.enums;

public enum BorderRadius {

    CIRCLE("50%"),
    ROUNDED("4px"),
    TILE("0px");

    private final String radius;

    BorderRadius(String radius) {
        this.radius = radius;
    }

    public String getRadius () {
        return radius;
    }
}
