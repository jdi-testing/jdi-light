package org.jdiai;

public class JSTemplates {
    public static String GET_LIST = "result = [];\n" +
            "for(let i = 0; i < elements%s; i++) {\n" +
            "  result.push(%s);\n" +
            "}\n";
    public static String GET_ONE_FROM_LIST = "found = false; i = 0;\n" +
            "while (!found && i < elements.length) {\n" +
            "  element = %s;\n" +
            "  if (element != null) { found = true; }\n" +
            "  i++;\n" +
            "}\n";
    public static String GET_LIST_FROM_LIST = "result = [];\n" +
            "for(let i = 0; i < elements%s; i++) {\n" +
            "  let subElements = %s;\n" +
            "  for(let j = 0; j < subElements%s; j++) {\n" +
            "    result.push(subElements%s);\n" +
            "  }\n" +
            "}\n" +
            "elements = result;\n";
}
