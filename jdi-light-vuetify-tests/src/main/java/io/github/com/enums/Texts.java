package io.github.com.enums;

public enum Texts {
    LEFTWITHSPACES("\n        Left\n      "),

    CENTERWITHSPACES("\n        Center\n      "),

    RIGHTWITHSPACES("\n        Right\n      "),
    JUSTIFYWITHSPACES("\n        Justify\n      "),

    LEFT("Left"),
    CENTER("Center"),
    RIGHT("Right"),
    JUSTIFY("Justify");

    private final String value;
    Texts(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
