package com.jdiai.jsbuilder;

public class JSTemplates {
    public static String XPATH_LIST_FUNC =
        "xpathList = function(ctx, locator) {\n" +
        "  let xpath = document.evaluate(locator, ctx, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);\n" +
        "  let xList = [];\n" +
        "  for (let i = 0; i < xpath.snapshotLength; i++)\n  {\n" +
        "    xList.push(xpath.snapshotItem(i));\n" +
        "  }\n" +
        "  return xList;\n" +
        "}\n";

    public static String XPATH_FUNC =
        "xpath = function(ctx, locator) {\n" +
        "   return document.evaluate(locator, ctx, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\n" +
        "}\n";

    public static String ONE_TO_RESULT = "return %s;\n";

    public static String LIST_TO_RESULT =
        "result = [];\n" +
        "for(let element of elements) {\n" +
        "  result.push(%s);\n" +
        "}\n" +
        "return result;";

    public static String ONE_TO_LIST = "Array.from(%s);\n";

    public static String PURE_ONE_TO_ONE = "%s;\n";
    public static String ONE_TO_ONE =
        "%s;\n" +
        "if (!element) { throw 'Failed to find element' };\n";

    public static String PURE_LIST_TO_ONE =
        "found = false;\ni = 0;\n" +
        "while (!found && i < elements.length) {\n" +
        "  element = %s;\n" +
        "  if (element !== null) { found = true; }\n" +
        "  i++;\n" +
        "}\n";
    public static String LIST_TO_ONE =
        PURE_LIST_TO_ONE +
        "if (!element) { throw 'Failed to find element' };\n";;

    public static String LIST_TO_LIST =
        "list = [];\n" +
        "for(let element of elements) {\n" +
        "  subElements = %s;\n" +
        "  for(let j = 0; j < subElements.length; j++) {\n" +
        "    list.push(subElements[j]);\n" +
        "  }\n" +
        "}\n" +
        "elements = Array.from(list);\n";
}
