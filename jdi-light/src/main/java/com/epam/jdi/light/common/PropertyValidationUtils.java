package com.epam.jdi.light.common;

import java.security.InvalidParameterException;
import java.util.Properties;

public class PropertyValidationUtils {

    public static final String EXAMPLE_MESSAGE = " See example: https://jdi-docs.github.io/jdi-light/#driver-settings";

    public static void validateProperties(Properties properties) {
        properties.forEach((k, v) -> validate(k.toString(), v.toString()));
    }

    public static void validate(String name, String value) {
        for (Property p : Property.values()) {
            if (p.getName().equals(name) && !value.matches(p.getCheck())) {
                throw new InvalidParameterException(p.getExMsg() + EXAMPLE_MESSAGE);
            }
        }
    }
}
