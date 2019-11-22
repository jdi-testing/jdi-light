package com.epam.jdi.light.common;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.TIMEOUT_WAIT_ELEMENT;

public class PropertyValidator {

    private static Map<String, Property> PROPERTY_MATCHERS = initMatchers();

    public static void validateProperties(Properties properties) {
        properties.forEach((k, v) -> validate(k.toString(), v.toString()));
    }

    public static void validate(String name, String value) {
        if (PROPERTY_MATCHERS.containsKey(name)) {
            Property property = PROPERTY_MATCHERS.get(name);
            if (!value.matches(property.getCheck())) {
                throw new InvalidParameterException(property.getExMsg() +
                        " See example: https://jdi-docs.github.io/jdi-light/#driver-settings");
            }
        }
    }

    private static Map<String, Property> initMatchers() {
        PROPERTY_MATCHERS = new HashMap<>();
        PROPERTY_MATCHERS.put(TIMEOUT_WAIT_ELEMENT.getName(), Property.TIMEOUT_WAIT_ELEMENT);
        return PROPERTY_MATCHERS;
    }
}
