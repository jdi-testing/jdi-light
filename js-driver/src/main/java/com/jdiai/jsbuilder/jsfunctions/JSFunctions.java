package com.jdiai.jsbuilder.jsfunctions;

public class JSFunctions {
    public static String XPATH_LIST_FUNC =
        "xpathList = function(ctx, locator) {\n" +
        "  let xpath = document.evaluate(locator, ctx, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);\n" +
        "  let xList = [];\n" +
        "  for (let i = 0; i < xpath.snapshotLength; i++) {\n" +
        "    xList.push(xpath.snapshotItem(i));\n" +
        "  }\n" +
        "  return xList;\n" +
        "}\n";

    public static String XPATH_FUNC =
        "xpath = function(ctx, locator) {\n" +
        "   return document.evaluate(locator, ctx, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\n" +
        "}\n";

    public static String ONE_TO_RESULT = "return %s;\n";

    public static String PURE_CONDITION_RESULT =
        "conditionResult = false;\n" +
        "if (!condition(element)) { throw 'Element found but does not meet condition %s'; }\n" +
        "return %s;\n";

    public static String CONDITION_RESULT =
        "conditionResult = false;\n" +
        "try { conditionResult = condition(element); } catch(ex) { }\n" +
        "if (!conditionResult) { throw 'Element found but does not meet condition %s'; }\n" +
        "return %s;\n";

    public static String LIST_TO_RESULT =
        "result = [];\n" +
        "for(let element of elements) {\n" +
        "  result.push(%s);\n" +
        "}\n" +
        "return result;";

    public static String PURE_CONDITION_LIST_TO_RESULT =
        "result = [];\n" +
        "for (let element of elements.filter(condition)) {\n" +
        "  result.push(%s);\n" +
        "}\n" +
        "return result;";

    public static String AGILE_LIST_TO_RESULT =
        "result = [];\nfiltered = []\n" +
        "try { filtered = elements.filter(condition); } catch { }\n" +
        "if (filtered.length == 0) { filtered = elements; }\n" +
        "for (let element of filtered.filter(condition)) {\n" +
        "  result.push(%s);\n" +
        "}\n" +
        "return result;";
}
