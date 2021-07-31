package com.jdiai.jsbuilder;

public class JSFilterTemplates {
    public static String WAIT_FOR_ELEMENT =
        "findElement = function() {\n" +
        "   {element}" +
        "   return element;\n" +
        "}\n" +
        // "let element;\n" +
        "start = Date.now();\n" +
        // "let searchError;\n" +
        "while (Date.now() - start < {timeout}) {\n" +
        "   try { element = findElement(); } catch { }\n" +
        "   if (!element) { searchError = 'Element not found'; continue; }\n" +
        "   let conditionResult;\n" +
        "   try { conditionResult = condition(element); } catch(ex) { }\n" +
        "   if (conditionResult) { break; } else { searchError = 'Element found but does not meet condition %s'; }\n" +
        "   element = undefined;\n" +
        "}\n" +
        "if (!element && searchError) {\n" +
        "   throw searchError;\n" +
        "}\n";

    public static String FILTER_FUNC =
        "filter = function(element) {\n" +
        "  return element && getComputedStyle(element).visibility === 'visible';\n" +
        "}\n";

    public static String ONE_TO_RESULT = "return %s;\n";

    public static String LIST_TO_RESULT =
        "let result = [];\n" +
        "for(let element of elements) {\n" +
        "  result.push(%s);\n" +
        "}\n" +
        "return result;";

    public static String ONE_TO_LIST =
        "%s;\n" +
        "list = [];\n" +
        "for(let element of elements) {\n" +
        "  if (filter(element)) {\n" +
        "    list.push(element);\n" +
        "  }\n" +
        "}\n" +
        "elements = Array.from(list.length === 0 ? elements[0] : list);\n";

    public static String ONE_TO_ONE = "%s;\n";

    public static String LIST_TO_ONE =
        "found = false;\ni = 0;\nfirst = null;\n" +
        "while (!found && i < elements.length) {\n" +
        "  element = %s;\n" +
        "  if (!first && element) { first = element; }\n" +
        "  if (filter(element)) { found = true; }\n" +
        "  i++;\n" +
        "}\n" +
        "if (!found && element) { element = first; }\n";

    public static String LIST_TO_LIST =
        "list = [];\nfirst = null;\n" +
        "for(let element of elements) {\n" +
        "  let subElements = %s;\n" +
        "  for(let j = 0; j < subElements.length; j++) {\n" +
        "    let subElement = subElements[j];\n" +
        "    if (!first && subElement) { first = subElement; }\n" +
        "    if (filter(subElement)) {\n" +
        "      list.push(subElement);\n" +
        "    }\n" +
        "  }\n" +
        "}\n" +
        "if (list.length === 0 && first) { list.push(first); };\n" +
        "elements = Array.from(list);\n";
}
