package com.epam.jdi.light.material.elements.utils.enums;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

public enum MessageType {
    ERROR("error"),
    WARNING("warning"),
    INFO("info"),
    SUCCESS("success");

    private final String value;

    MessageType(String value) {
        this.value = value;
    }

    public String getMessageType() {
        return value;
    }

    public static MessageType fromString(String text) {
        for (MessageType b : MessageType.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw runtimeException(String.format("No appropriate %s constant found for value '%s'", MessageType.class.getName(), text));
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
