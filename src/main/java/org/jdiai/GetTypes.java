package org.jdiai;

import org.openqa.selenium.By;

import static org.jdiai.WebDriverByUtils.getByType;

public class GetTypes {
    public static GetData CSS = new GetData(
        "{0}.querySelector(''{1}'')",
        "{0}.querySelectorAll(''{1}'')");
    public static GetData XPATH = new GetData(
        "xpath({0}, ''{1}'')",
        "xpathList({0}, ''{1}'')");
    public static GetData ID = new GetData(
        "{0}.getElementById(''{1}'')",
        "[...{0}.getElementById(''{1}'')]");
    public static GetData CLASS = new GetData(
        "{0}.getElementsByClassName(''{1}'')[0]",
        "{0}.getElementsByClassName(''{1}'')");
    public static GetData NAME = new GetData(
        "{0}.getElementsByName(''{1}'')[0]",
        "{0}.getElementsByName(''{1}'')");
    public static GetData TAG = new GetData(
        "{0}.getElementsByTagName(''{1}'')[0]",
        "{0}.getElementsByTagName(''{1}'')");
    public static GetData dataType(By locator) {
        switch (getByType(locator)) {
            case "id": return  ID;
            case "tag": return TAG;
            case "name": return NAME;
            case "class": return CLASS;
            case "css": return CSS;
            case "xpath": return XPATH;
            case "frame": return ((ByFrame)locator).type.equals("id") ? ID : CSS;
        }
        throw new RuntimeException("Unknown locator type: " + locator);
    }
}
