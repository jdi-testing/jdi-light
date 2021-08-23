package com.jdiai.jsbuilder.jsfunctions;

public class JSListToOne {
    public static String PURE_LIST_TO_ONE =
        "if (elements.length === 0) { throw 'Failed to find element' }\n" +
        "element = elements.map(e => {{one:e}})[0];\n";

    public static String LIST_TO_ONE =
        "if (elements.length === 0) { throw 'Failed to find element' }\n" +
        "elements = elements.map(e => {{one:e}}).filter(e=>!!e);" +
        "if (elements.length === 0) { throw 'Failed to find element' };\n" +
        "element = elements[0];\n";

    public static String FILTER_LIST_TO_ONE =
        "if (elements.length === 0) { throw 'Failed to find element' }\n" +
        "element = elements.map(e => {{filter}}({{one:e}}));\n" +
        "if (!element) { throw 'Failed to find element' };\n";

    public static String AGILE_LIST_TO_ONE =
        "if (elements.length === 0) { throw 'Failed to find element' }\n" +
        "i = 0;\nfirst = null;\n" +
        "while (!found && i < elements.length) {\n" +
        "  element = {{one:elements[i]}};\n" +
        "  if (!first && element) { first = element; }\n" +
        "  if ({{filter}}(element)) { break; }\n" +
        "  i++;\n" +
        "}\n" +
        "if (!element && first) { element = first; }\n" +
        "if (!element) { throw 'Failed to find element' };\n";
}
