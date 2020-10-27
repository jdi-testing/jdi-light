package org.jdiai;

public class JSTemplates {
    public static String LIST_TO_RESULT =
        "var result = [];\n" +
        "for(let i = 0; i < elements%s; i++) {\n" +
        "  result.push(%s);\n" +
        "}\n";
    public static String ONE_TO_LIST = "%s";
    public static String ONE_TO_ONE = "%s";
    public static String LIST_TO_ONE =
        "var found = false;\nvar i = 0;\n" +
        "while (!found && i < elements.length) {\n" +
        "  element = %s" +
        "  if (element != null) { found = true; }\n" +
        "  i++;\n" +
        "}\n";
    public static String LIST_TO_LIST =
        "var result = [];\n" +
        "for(let element of elements) {\n" +
        "  let subElements = %s" +
        "  for(let j = 0; j < subElements%s; j++) {\n" +
        "    result.push(subElements%s);\n" +
        "  }\n" +
        "}\n" +
        "elements = result;\n";
}
