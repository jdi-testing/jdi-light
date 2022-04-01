package com.epam.jdi.light.material.elements.utils.enums;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * Contains named constants representing element positions.
 * Each constant includes information about its string representation.
 */
public enum Position {
    TOP("top"),
    BOTTOM("bottom"),
    LEFT("left"),
    RIGHT("right"),
    END("end"),
    START("start"),
    TOP_RIGHT("topRight"),
    TOP_LEFT("topLeft"),
    TOP_CENTER("topCenter"),
    BOTTOM_CENTER("bottomCenter"),
    BOTTOM_RIGHT("bottomRight"),
    BOTTOM_LEFT("bottomLeft");

    private final String value;

    Position(String value) {
        this.value = value.toLowerCase();
    }

    /**
     * Gets {@link Position} named constant from the given string.
     *
     * @return position as {@link Position}
     * @throws RuntimeException if no appropriate constant found for given value
     */
    public static Position fromString(String text) {
        for (Position b : Position.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw runtimeException(String.format("No appropriate %s constant found for value '%s'", Position.class.getName(), text));
    }

    /**
     * Gets string representation of element position in CamelCase (e.g. "bottom", "bottomLeft").
     *
     * @return element position as {@link String}
     */
    @Override
    public String toString() {
        return value;
    }
}
