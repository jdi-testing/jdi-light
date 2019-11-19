package com.epam.jdi.light.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.PropertyName.TIMEOUT_WAIT_ELEMENT;

public class PropertyValidator {

    private static Map<String, String> PROPERTY_MATCHERS = initMatchers();

    public static void validateProperties(Properties properties) {
        properties.forEach((k, v) -> validate(k.toString(), v.toString()));
    }

    public static void validate(String name, String value) {
        if (PROPERTY_MATCHERS.containsKey(name) && !value.matches(PROPERTY_MATCHERS.get(name))) {
            throw exception("Value of parameter '%s' is not valid.", name);
        }
    }

    private static Map initMatchers() {
        PROPERTY_MATCHERS = new HashMap<>();
        PROPERTY_MATCHERS.put(TIMEOUT_WAIT_ELEMENT, "\\d+");
        return PROPERTY_MATCHERS;
    }
}
