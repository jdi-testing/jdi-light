package com.epam.jdi.light.material.elements.utils.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

public enum Severity {
    INFO("Info"),
    SUCCESS("Success"),
    WARNING("Warning"),
    ERROR("Error");

    private final String value;

    Severity(String value) {
        this.value = value;
    }

    public static Severity fromStyle(String className, String prefix) {
        String expSeverity = className.replace(prefix, "");

        return Arrays.stream(Severity.values())
                .filter(p -> StringUtils.equalsIgnoreCase(expSeverity, p.toString()))
                .findAny()
                .orElseThrow(() -> runtimeException(String.format("%s: There is no Severity with this value",
                    className)));
    }
}
