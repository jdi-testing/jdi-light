package io.github.com.enums;

public enum Texts {
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
