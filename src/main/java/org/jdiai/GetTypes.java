package org.jdiai;

import org.openqa.selenium.By;

import static org.jdiai.WebDriverByUtils.getByType;

public class GetTypes {
    public static GetData CSS = new GetData(
        "ctx.querySelector(''%s'')",
        "ctx.querySelectorAll(''%s'')",
        ".length",
        "[%s]");
    public static GetData XPATH = new GetData(
        "document.evaluate(''%s'', ctx, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue",
        "document.evaluate(''%s'', ctx, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null)",
        ".snapshotLength",
        ".snapshotItem(%s)");
    public static GetData ID = new GetData(
        "ctx.getElementById(''%s'')",
        "[...ctx.getElementById(''%s'')]",
        ".length",
        "[%s]");
    public static GetData CLASS = new GetData(
        "ctx.getElementsByClassName(''%s'')[0]",
        "ctx.getElementsByClassName(''%s'')",
        ".length",
        "[%s]");
    public static GetData NAME = new GetData(
        "ctx.getElementsByName(''%s'')[0]",
        "ctx.getElementsByName(''%s'')",
        ".length",
        "[%s]");
    public static GetData TAG = new GetData(
        "ctx.getElementsByTagName(''%s'')[0]",
        "ctx.getElementsByTagName(''%s'')",
        ".length",
        "[%s]");
    public static GetData dataType(By locator) {
        switch (getByType(locator)) {
            case "id": return ID;
            case "tagName": return TAG;
            case "name": return NAME;
            case "className": return CLASS;
            case "css": return CSS;
            case "xpath": return XPATH;
        }
        throw new RuntimeException("Unknown locator type: " + locator);
    }
}
