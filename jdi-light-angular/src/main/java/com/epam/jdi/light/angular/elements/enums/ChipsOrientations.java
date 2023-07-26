package com.epam.jdi.light.angular.elements.enums;

public enum ChipsOrientations {
    HORIZONTAL("horizontal"),
    VERTICAL("vertical");

    private final String orientation;

    ChipsOrientations(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return this.orientation;
    }

}
