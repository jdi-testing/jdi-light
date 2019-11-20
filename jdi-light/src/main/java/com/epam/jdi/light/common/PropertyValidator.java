package com.epam.jdi.light.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.epam.jdi.light.common.Exceptions.exception;

public class PropertyValidator {

    private static Map<String, String> PROPERTY_MATCHERS = initMatchers();

    public static final String TIMEOUT_WAIT_ELEMENT = "timeout.wait.element";

    public static void validateProperties(Properties properties) {
        properties.forEach((k, v) -> validate(k.toString(), v.toString()));
    }

    public static void validate(String name, String value) {
        if (PROPERTY_MATCHERS.containsKey(name) && !value.matches(PROPERTY_MATCHERS.get(name))) {
            throw exception("Value of parameter '%s' is not valid." +
                    " See example: https://jdi-docs.github.io/jdi-light/#driver-settings", name);
        }
    }

    private static Map<String, String> initMatchers() {
        PROPERTY_MATCHERS = new HashMap<>();
        PROPERTY_MATCHERS.put(TIMEOUT_WAIT_ELEMENT, "^[1-9][0-9]{1,2}$|^\\d$");
        return PROPERTY_MATCHERS;
    }
}
