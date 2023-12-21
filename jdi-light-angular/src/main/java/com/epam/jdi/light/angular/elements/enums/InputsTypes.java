package com.epam.jdi.light.angular.elements.enums;

import java.util.Arrays;

public enum InputsTypes {
    COLOR("color"),
    DATE("date"),
    DATETIME_LOCAL("datetime-local"),
    EMAIL("email"),
    MONTH("month"),
    NUMBER("number"),
    PASSWORD("password"),
    SEARCH("search"),
    TEL("tel"),
    TEXT("text"),
    TIME("time"),
    URL("url"),
    WEEK("week");

    private final String type;

    InputsTypes(String label) {
        this.type = label;
    }

    public String getType() {
        return type;
    }

    public static int size() {
        return values().length;
    }

    public static InputsTypes fromType(String type) {
        return Arrays.stream(values())
                     .filter(t -> t.type.equalsIgnoreCase(type))
                     .findFirst()
                     .orElse(TEXT);
    }
}
