package io.github.com.enums;

public enum ButtonNames {
    LEFT("Left"),
    CENTER("Center"),
    RIGHT("Right"),
    JUSTIFY("Justify"),
    CONNECTION_SETTINGS("CONNECTION SETTINGS"),
    DISMISS("DISMISS"),
    RETRY("RETRY"),
    ACTION("ACTION");

    private final String value;
    ButtonNames(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
