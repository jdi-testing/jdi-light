package com.epam.jdi.light.angular.elements.enums.buttons;

public enum ButtonsTypes {
    BASIC("mat-button"),
    RAISED("mat-raised-button"),
    STROKED("mat-stroked-button"),
    FLAT("mat-flat-button"),
    ICON("mat-icon-button"),
    EXTENDED_FAB("extended"),
    FAB("mat-fab"),
    MINI_FAB("mat-mini-fab");

    private final String type;

    ButtonsTypes(String label) {
        this.type = label;
    }

    public String getType() {
        return type;
    }

    public static int size() {
        return values().length;
    }
}
