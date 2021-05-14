package com.jditest.tools;

import com.jditest.JS;

import java.util.function.Function;

import static java.lang.String.format;

public class FilterConditions {
    public static Function<JS, String> textEquals(String value) {
        return el -> format("element.%s === '%s'", el.textType.value, value);
    }
    public static Function<JS, String> textContains(String value) {
        return el -> format("element.%s.toLowerCase().includes('%s'.toLowerCase())",
            el.textType.value, value);
    }
    public static Function<JS, String> hasAttribute(String attrName) {
        return el -> "element.hasAttribute('" + attrName + "')";
    }
    public static Function<JS, String> hasAttribute(String attrName, String value) {
        return el -> format("element.getAttribute('%s').equals('%s')", attrName, value);
    }
    public static Function<JS, String> hasTag(String value) {
        return el -> "element.tag === " + value;
    }
    public static Function<JS, String> hasClass(String value) {
        return el -> "element.hasClass('" + value + "')";
    }
}
