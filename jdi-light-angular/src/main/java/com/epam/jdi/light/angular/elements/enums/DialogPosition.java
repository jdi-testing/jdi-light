package com.epam.jdi.light.angular.elements.enums;

import java.util.Arrays;

public enum DialogPosition {
    START("start"),
    CENTER("center"),
    END("end");

    private final String position;

    DialogPosition(String label) {
        this.position = label;
    }

    public String getPosition() {
        return position;
    }

    public static int size() {
        return values().length;
    }

    public static DialogPosition from(String position) {
        return Arrays.stream(values())
                .filter(p -> p.position.equalsIgnoreCase(position))
                .findFirst()
                .orElse(START);
    }
}
