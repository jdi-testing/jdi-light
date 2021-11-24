package com.epam.jdi.light.material.elements.utils.enums;

public enum LabelPosition {
    TOP("MuiFormControlLabel-labelPlacementTop"),
    BOTTOM("MuiFormControlLabel-labelPlacementBottom"),
    START("MuiFormControlLabel-labelPlacementStart"),
    END("");

    String position;

    public String getPosition() {
        return position;
    }

    LabelPosition(String position) {
        this.position = position;
    }
}
