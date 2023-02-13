package com.epam.jdi.light.vuetify.enums;

public enum SortOrder {
    ASCENDING("ascending"),
    DESCENDING("descending"),
    NONE("none");

    private final String order;

    SortOrder(String order) {
        this.order = order;
    }
}
