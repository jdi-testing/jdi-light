package org.jdiai;

public class JSSmartTemplates {
    public static String FILTER_FUNC =
        "function filter(element)\n{\n" +
        "  return element != null && getComputedStyle(element).visibility === 'visible';\n" +
        "}\n";
    public static String ONE_TO_RESULT = "return %s;";
    public static String LIST_TO_RESULT =
        "let result = [];\n" +
        "for(let element of elements) {\n" +
        "  result.push(%s);\n" +
        "}\n" +
        "return result;";
    public static String ONE_TO_LIST =
        "%s" +
        "list = [];\n" +
        "for(let element of elements) {\n" +
        "  if (filter(element)) {\n" +
        "    list.push(element);\n" +
        "  }\n" +
        "}\n" +
        "elements = list.length === 0 ? elements[0] : list;\n";
    public static String ONE_TO_ONE = "%s";
    public static String LIST_TO_ONE =
        "found = false;\ni = 0;\nfirst = null;" +
        "while (!found && i < elements.length) {\n" +
        "  element = %s" +
        "  if (first === null && element !== null) { first = element; }\n" +
        "  if (filter(element)) { found = true; }\n" +
        "  i++;\n" +
        "}\n" +
        "if (!found && element !== null) { element = first; }\n";
    public static String LIST_TO_LIST =
        "list = [];\nfirst = null;" +
        "for(let element of elements) {\n" +
        "  let subElements = %s" +
        "  for(let j = 0; j < subElements.length; j++) {\n" +
        "    let subElement = subElements[j];\n" +
        "    if (first === null && subElement !== null) { first = subElement; }\n" +
        "    if (filter(subElement)) {\n" +
        "      list.push(subElement);\n" +
        "    }\n" +
        "  }\n" +
        "}\n" +
        "if (list.length === 0 && first !== null) { list.push(first); };\n" +
        "elements = list;\n";
}
