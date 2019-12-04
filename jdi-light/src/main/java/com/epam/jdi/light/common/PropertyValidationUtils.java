package com.epam.jdi.light.common;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.tools.StringUtils.LINE_BREAK;

public class PropertyValidationUtils {

    public static final String LINK_TO_EXAMPLES = " See examples: https://jdi-docs.github.io/jdi-light/#driver-settings" +
            LINE_BREAK + "https://jdi-docs.github.io/jdi-light/#jdi-settings";

    public static void validateProperties(Properties properties) {
        properties.forEach((k, v) -> validate(k.toString(), v.toString()));
    }

    public static void validate(String name, String value) {
        for (Property p : Property.values()) {
            if (p.getName().equals(name) && !value.matches(p.getCheck())) {
                throw new InvalidParameterException(p.getExMsg() + LINK_TO_EXAMPLES);
            }
        }
    }
}
