package com.epam.jdi.light.material.elements.utils.enums;

public enum MessageType {
    ERROR("error"),
    WARNING("warning"),
    INFO("info"),
    SUCCESS("success");

    private final String messageType;

    public String getMessageType() {
        return messageType;
    }

    MessageType(String messageType) {
        this.messageType = messageType;
    }
}
