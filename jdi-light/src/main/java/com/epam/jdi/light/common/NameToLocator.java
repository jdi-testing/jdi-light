package com.epam.jdi.light.common;

import com.epam.jdi.tools.StringUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;

import static com.epam.jdi.tools.map.MapArray.*;
import static com.epam.jdi.tools.pairs.Pair.$;

public class NameToLocator {
    public static MapArray<String, JFunc1<String, String>> SMART_MAP_NAME_TO_LOCATOR = map(
        $("camelCase",  StringUtils::toCamelCase),
        $("snake_case", StringUtils::toSnakeCase),
        $("kebab-case", StringUtils::toKebabCase),
        $("PascalCase", StringUtils::toPascalCase),
        $("UPPER_SNAKE_CASE", StringUtils::toUpperSnakeCase),
        $("First Upper Case", StringUtils::splitCamelCase),
        $("ALL UPPER CASE", value -> StringUtils.splitCamelCase(value).toUpperCase()));
}
