package org.jdiai;

import org.openqa.selenium.By;

import static org.jdiai.WebDriverByUtils.getByType;

public class GetTypes {
    public static GetData CSS = new GetData(
        ".querySelector('%s')",
        ".querySelectorAll('%s')",
        ".length",
        "[%s]");
    public static GetData XPATH = new GetData(
        ".evaluate('%s', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue",
        ".evaluate('%s', document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null)",
        ".snapshotLength",
        ".snapshotItem(i)");
    public static GetData ID = new GetData(
        ".getElementById('%s')",
        ".querySelectorAll('#%s')",
        ".length",
        "[%s]");
    public static GetData CLASS = new GetData(
        ".getElementsByClassName('%s')[0]",
        ".getElementsByClassName('%s')",
        ".length",
        "[%s]");
    public static GetData NAME = new GetData(
        ".getElementsByName('%s')[0]",
        ".getElementsByName('%s')",
        ".length",
        "[%s]");
    public static GetData TAG = new GetData(
        ".getElementsByTagName('%s')[0]",
        ".getElementsByTagName('%s')",
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
