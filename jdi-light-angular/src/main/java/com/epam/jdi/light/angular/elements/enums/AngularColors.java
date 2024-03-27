package com.epam.jdi.light.angular.elements.enums;

import java.util.Arrays;

public enum AngularColors  {

    PRIMARY("primary"),
    ACCENT("accent"),
    WARN("warn"),
    UNSELECTED("unselected"),
    DEFAULT("default"),
    UNDEFINED("undefined");

    String type;

    AngularColors(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    public static AngularColors fromType(String type) {
        return Arrays.stream(values())
                .filter(t -> t.type.equalsIgnoreCase(type))
                .findFirst()
                .orElse(UNDEFINED);
    }
}
