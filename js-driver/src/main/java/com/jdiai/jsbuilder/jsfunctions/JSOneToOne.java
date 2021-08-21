package com.jdiai.jsbuilder.jsfunctions;

public class JSOneToOne {
    public static String PURE_ONE_TO_ONE = "element = {{one}};\n";

    public static String ONE_TO_ONE =
        "element = {{one}};\n" +
        "if (!element) { throw 'Failed to find element' };\n";

    public static String FIND_ONE =
        "element = elements.find(element => element && %s);\n" +
        "if (!element) { throw 'Failed to find element' };\n";

    public static String PURE_STRICT_ONE_TO_ONE =
        "elements = Array.from({{list}}).filter(e=>!!e);\n" +
        "element = elements.find(filter);\n";

    public static String STRICT_ONE_TO_ONE =
        "element;\n" +
        "try { element = Array.from({{list}}).filter(e=>!!e).find(filter); } catch { }\n" +
        "if (!element) { throw 'Failed to find element' };\n";

    public static String AGILE_ONE_TO_ONE =
        "elements = Array.from({{list}}).filter(e=>!!e);\n" +
        "if (elements.length === 0) { throw 'Failed to find element' }\n" +
        "element = elements.length === 1 ? elements[0] : elements.find(filter);\n" +
        "if (!element) { throw 'Failed to find element' };\n";
}
