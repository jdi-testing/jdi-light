package com.epam.jdi.light.material.elements.utils.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

public enum MUIColor {
    PRIMARY("Primary"),
    INHERIT("Interit"),
    SECONDARY("Secondary"),
    DEFAULT("Default"),
    TRANSPARENT("Transparent");

    private final String value;

    MUIColor(String value) {
        this.value = value;
    }

    public static MUIColor fromStyle(String className, String prefix) {
        String expColor = className.replace(prefix, "");

        return Arrays.stream(MUIColor.values())
                .filter(p -> StringUtils.equalsIgnoreCase(expColor, p.toString()))
                .findAny()
                .orElseThrow(() -> runtimeException(String.format("%s: There is no Severity with this value",
                        className)));
    }
}
