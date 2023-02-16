package com.epam.jdi.light.vuetify.enums;
public enum AlertType {
    INFO("info"),
    SUCCESS("success"),
    WARNING("warning"),
    ERROR("error"),
    UNDEFINED("");
    private final String value;
    AlertType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
