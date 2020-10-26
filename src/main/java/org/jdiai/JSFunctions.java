package org.jdiai;

public class JSFunctions {
    public static String ONE_TO_ONE = "function get_one(ctx) { return %s; }";
    public static String ONE_TO_LIST = "function get_list(ctx) { return %s; }";

    public static String LIST_RESULT = "function list_result(elements) {\n" +
        "let result = [];\n" +
        "for(let i = 0; i < elements%s; i++) {\n" +
        "  result.push(elements%s.%s);\n" +
        "}\nreturn result;";

    public static String GET_ONE_FROM_LIST = "function list_to_one(elements) {\n" +
        "let found = false;\nlet i = 0;\nlet element;\n" +
        "while (!found && i < elements.length) {\n" +
        "  element = %s;\n" +
        "  if (element != null) { found = true; }\n" +
        "  i++;\n" +
        "}\nreturn element;";
    public static String GET_LIST_FROM_LIST = "function list_to_list(elements) {\n" +
        "let result = [];\n" +
        "for(let i = 0; i < elements%s; i++) {\n" +
        "  let subElements = %s;\n" +
        "  for(let j = 0; j < subElements%s; j++) {\n" +
        "    result.push(subElements%s);\n" +
        "  }\n" +
        "}\nreturn result;\n";
}
