package com.epam.jdi.light.angular.elements.enums.buttons;

public enum ButtonsTypes {
    BASIC("basic"),
    RAISED("raised"),
    STROKED("stroked"),
    FLAT("flat"),
    ICON("icon"),
    FAB("fab"),
    MINI_FAB("mini fab");

    private final String label;

    ButtonsTypes(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
