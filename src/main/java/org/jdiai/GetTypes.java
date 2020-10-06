package org.jdiai;

import org.openqa.selenium.By;

import static org.jdiai.WebDriverByUtils.getByType;

public class GetTypes {
    public static GetData CSS = new GetData(
        "{0}.querySelector(''{1}'')",
        "{0}.querySelectorAll(''{1}'')",
        ".length",
        "[%s]");
    public static GetData XPATH = new GetData(
        "document.evaluate(''{1}'', {0}, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue",
        "document.evaluate(''{1}'', {0}, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null)",
        ".snapshotLength",
        ".snapshotItem(%s)");
    public static GetData ID = new GetData(
        "{0}.getElementById(''{1}'')",
        "[...{0}.getElementById(''{1}'')]",
        ".length",
        "[%s]");
    public static GetData CLASS = new GetData(
        "{0}.getElementsByClassName(''{1}'')[0]",
        "{0}.getElementsByClassName(''{1}'')",
        ".length",
        "[%s]");
    public static GetData NAME = new GetData(
        "{0}.getElementsByName(''{1}'')[0]",
        "{0}.getElementsByName(''{1}'')",
        ".length",
        "[%s]");
    public static GetData TAG = new GetData(
        "{0}.getElementsByTagName(''{1}'')[0]",
        "{0}.getElementsByTagName(''{1}'')",
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
