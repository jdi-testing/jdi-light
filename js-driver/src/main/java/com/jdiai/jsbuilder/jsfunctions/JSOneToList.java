package com.jdiai.jsbuilder.jsfunctions;

public class JSOneToList {
    public static String ONE_TO_LIST = "elements = Array.from({{list}}).filter(e=>!!e);\n";

    public static String FILTER_ONE_TO_LIST =
        "elements = Array.from({{list}}).filter(e=>e && {{filter}}(e));\n";

    public static String AGILE_ONE_TO_LIST =
        "elements = Array.from({{list}}).filter(e=>!!e);\n" +
        "if (elements.length > 0) {\n" +
        "  filtered = elements.filter({{filter}});\n" +
        "  if (filtered > 0) { elements = filtered; }\n" +
        "}\n";

}
