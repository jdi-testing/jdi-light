package com.epam.jdi.light.angular.elements.enums;

import org.apache.commons.lang3.StringUtils;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

/**
 * Contains named constants representing element positions.
 * Each constant includes information about its string representation.
 */
public enum Position {
    TOP(null, "align-items: flex-start;"),
    BOTTOM(null, "align-items: flex-end;"),

    CENTER("justify-content: center;", null),
    LEFT("justify-content: flex-start;", null),
    RIGHT("justify-content: flex-end;", null),

    CENTER_BOTTOM("justify-content: center;", "align-items: flex-end;"),
    LEFT_BOTTOM("justify-content: flex-start;", "align-items: flex-end;"),
    RIGHT_BOTTOM("justify-content: flex-end;", "align-items: flex-end;"),
    CENTER_TOP("justify-content: center;", "align-items: flex-start;"),
    LEFT_TOP("justify-content: flex-start;", "align-items: flex-start;"),
    RIGHT_TOP("justify-content: flex-end;", "align-items: flex-start;");
    private static String justifyContent = "justify-content";
    private static String alignItems = "align-items";
    private final String horizontalPosition;
    private final String verticalPosition;

    Position(String horizontalPosition, String verticalPosition) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
    }

    public String getHorizontalPosition() {
        return horizontalPosition;
    }

    public String getVerticalPosition() {
        return verticalPosition;
    }

    public static Position fromFullString(String text) {
        if (StringUtils.isBlank(text)) {
            throw runtimeException(String.format("%s: input string can't be empty", Position.class.getName()));
        }
        boolean horizontalPositionMatches = containsIgnoreCase(text, justifyContent);
        boolean verticalPositionMatches = containsIgnoreCase(text, alignItems);
        for (Position position : Position.values()) {
            boolean horizontal;
            boolean vertical;
            if (horizontalPositionMatches) {
                horizontal = containsIgnoreCase(text, position.horizontalPosition);
            } else {
                horizontal = position.horizontalPosition == null;
            }
            if (verticalPositionMatches) {
                vertical = containsIgnoreCase(text, position.verticalPosition);
            } else {
                vertical = position.verticalPosition == null;
            }
            if (horizontal && vertical) {
                return position;
            }
        }
        throw runtimeException(String.format("No appropriate %s constant found for value '%s'", Position.class.getName(), text));
    }

    public String toString() {
        return justifyContent + " " + verticalPosition;
    }
}
