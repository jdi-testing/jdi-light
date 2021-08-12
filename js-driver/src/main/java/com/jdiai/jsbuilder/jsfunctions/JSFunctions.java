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
}
