package com.epam.jdi.light.material.elements.utils.enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
    BOTTOM_LEFT("bottomLeft"),
    STATIC("Static");

    private final String value;

    Position(String value) {
        this.value = value.toLowerCase();
    }

    /**
     * Gets {@link Position} full named constant from the given string.
     *
     * @param text String value for position
     * @return position as {@link Position}
     * @throws RuntimeException if no appropriate constant found for given value
     */
    public static Position fromFullString(String text) {
        if (StringUtils.isBlank(text)) {
            throw runtimeException(String.format("%s: input string can't be empty", Position.class.getName()));
        }
        return Arrays.stream(Position.values())
                .filter(p -> StringUtils.containsAnyIgnoreCase(text, p.toString()))
                .max(Comparator.comparing(p -> p.toString().length()))
                .orElseThrow(() -> runtimeException(String.format("No appropriate %s constant found for value '%s'", Position.class.getName(), text)));
    }

    public static Position fromClasses(List<String> classes, String stylePrefix, String stylePostfix) {
        if (classes == null || classes.isEmpty() || StringUtils.isBlank(stylePrefix)) {
            throw runtimeException(String.format("%s: input string can't be empty",
                    Position.class.getName()));
        }
        String positionClass = classes.stream()
                .filter(c -> StringUtils.containsAnyIgnoreCase(c, stylePrefix))
                .map(c -> c.replaceFirst(stylePrefix, "").replace(stylePostfix, ""))
                .findFirst().orElse("");
        if (StringUtils.isBlank(positionClass)) {
            throw runtimeException(String.format("%s: input string can't be empty",
                    Position.class.getName()));
        }
        return Arrays.stream(Position.values())
                .filter(p -> StringUtils.equalsIgnoreCase(positionClass, p.toString()))
                .findAny()
                .orElseThrow(() -> runtimeException(String.format("No appropriate %s constant found for value '%s'",
                        Position.class.getName(), positionClass)));
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
