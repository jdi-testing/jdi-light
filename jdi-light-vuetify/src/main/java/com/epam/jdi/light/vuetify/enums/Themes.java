package com.epam.jdi.light.vuetify.enums;

public enum Themes {
    THEME_DARK("theme--dark"),
    THEME_LIGHT("theme--light");

    private final String value;

    Themes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }
}
