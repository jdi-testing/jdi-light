package com.epam.jdi.light.common;

import com.jdiai.tools.StringUtils;
import com.jdiai.tools.func.JFunc1;
import com.jdiai.tools.map.MapArray;

import static com.jdiai.tools.map.MapArray.map;
import static com.jdiai.tools.pairs.Pair.$;

public class NameToLocator {
    public static MapArray<String, JFunc1<String, String>> SMART_MAP_NAME_TO_LOCATOR = map(
        $("camelCase",  StringUtils::toCamelCase),
        $("snake_case", StringUtils::toSnakeCase),
        $("kebab-case", StringUtils::toKebabCase),
        $("PascalCase", StringUtils::toPascalCase),
        $("UPPER_SNAKE_CASE", StringUtils::toUpperSnakeCase),
        $("First Upper Case", StringUtils::splitCamelCase),
        $("ALL UPPER CASE", value -> StringUtils.splitCamelCase(value).toUpperCase()),
        $("First capital", StringUtils::splitFirstCapital),
        $("As Is", value -> value));
}
