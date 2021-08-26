package com.jdiai.tools;

import org.openqa.selenium.By;

import java.util.function.Function;

import static com.jdiai.tools.StringUtils.toKebabCase;
import static org.openqa.selenium.By.*;

public class TestIDLocators {
    public static final Function<String, By> DATA_TEST_ID = fieldName ->
        cssSelector("[data-testid='" + toKebabCase(fieldName) + "']");
    public static final Function<String, By> ID_LOCATOR = fieldName ->
        id(toKebabCase(fieldName));
    public static final Function<String, By> CLASS_LOCATOR = fieldName ->
        className(toKebabCase(fieldName));
    public static final Function<String, By> NAME_LOCATOR = fieldName ->
        name(toKebabCase(fieldName));

    public static Function<String, By> SMART_LOCATOR = DATA_TEST_ID;

}
