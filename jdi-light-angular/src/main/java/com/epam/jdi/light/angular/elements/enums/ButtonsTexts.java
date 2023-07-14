package com.epam.jdi.light.angular.elements.enums;

public enum ButtonsTexts {

    BASIC_TEXT("Basic"),
    PRIMARY_TEXT("Primary"),
    ACCENT_TEXT("Accent"),
    WARN_TEXT("Warn"),
    DISABLED_TEXT("Disabled"),
    LINK_TEXT("Link");

    private final String text;

    ButtonsTexts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
