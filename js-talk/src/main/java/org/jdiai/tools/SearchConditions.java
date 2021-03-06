package org.jdiai.tools;

import java.util.function.Function;

import static java.lang.String.format;

public class SearchConditions {
    public static final Function<Condition, String> textEquals =
        c -> format("%s === '%s'", c.textType.value, c.value);
    public static final Function<Condition, String> textContains =
        c -> format("%s.toLowerCase().includes('%s'.toLowerCase())", c.textType.value, c.value);
    public static final Function<Condition, String> hasAttribute =
        c -> "hasAttribute('" + c.attrName + "')";
    public static final Function<Condition, String> hasAttributeValue =
        c -> format("getAttribute('%s').equals('%s')", c.attrName, c.value);
    public static final Function<Condition, String> hasTag =
        c -> "tag === " + c.value;
    public static final Function<Condition, String> hasClass =
        c -> "hasClass('" + c.value + "')";
}
