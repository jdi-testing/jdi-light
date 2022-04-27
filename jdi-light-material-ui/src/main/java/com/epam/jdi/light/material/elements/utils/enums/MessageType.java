package com.epam.jdi.light.material.elements.utils.enums;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * Contains named constants representing element message types.
 * Each constant includes information about its string representation.
 */
public enum MessageType {
    ERROR("error"),
    WARNING("warning"),
    INFO("info"),
    SUCCESS("success");

    private final String value;

    MessageType(String value) {
        this.value = value;
    }

    /**
     * Gets {@link MessageType} named constant from the given string.
     *
     * @return message type as {@link MessageType}
     * @throws RuntimeException if no appropriate constant found for given value
     */
    public static MessageType fromString(String text) {
        for (MessageType b : MessageType.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw runtimeException(String.format("No appropriate %s constant found for value '%s'", MessageType.class.getName(), text));
    }

    /**
     * Gets string representation of element message type in CamelCase (e.g. "warning", "Warning").
     *
     * @return element message type as {@link String}
     */
    @Override
    public String toString() {
        return value;
    }
}
