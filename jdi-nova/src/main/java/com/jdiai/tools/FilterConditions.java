package com.jdiai.tools;

import com.jdiai.JS;

import java.util.function.Function;

import static java.lang.String.format;

public class FilterConditions {
    public static Function<JS, String> textEquals(String value) {
        return el -> format("%s === '%s'", el.textType.value, value);
    }
    public static Function<JS, String> textContains(String value) {
        return el -> format("%s.toLowerCase().includes('%s'.toLowerCase())",
            el.textType.value, value);
    }
    public static Function<JS, String> hasAttribute(String attrName) {
        return el -> "hasAttribute('" + attrName + "')";
    }
    public static Function<JS, String> hasAttribute(String attrName, String value) {
        return el -> format("(#element#.getAttribute('%s') ?? '').equals('%s')", attrName, value);
    }
    public static Function<JS, String> hasTag(String value) {
        return el -> "element.tag === " + value;
    }
    public static Function<JS, String> hasClass(String value) {
        return el -> "classList.contains('" + value + "')";
    }
}
