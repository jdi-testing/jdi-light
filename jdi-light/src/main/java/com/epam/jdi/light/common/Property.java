package com.epam.jdi.light.common;

public enum Property {

    TIMEOUT_WAIT_ELEMENT("timeout.wait.element", "^[1-9][0-9]{1,2}$|^\\d$",
            "Value of 'timeout.wait.element' must be an integer from 0 to 999."),
    BROWSER_SIZE("browser.size", "MAXIMIZE|^([1-9][0-9]{2,3})x([1-9][0-9]{2,3})$",
            "Value of 'browser.size' must be 'MAXIMIZE' or two integers from 100 to 9999 between symbol 'x', " +
                    "for instance: 1920x1080."),
    PAGE_LOAD_STRATEGY("page.load.strategy", "normal|eager|none",
            "Value of 'page.load.strategy' must be 'normal', 'eager' or 'none'."),
    PAGE_CHECK_AFTER_OPEN("page.check.after.open", "NONE|NEW_PAGE|EVERY_PAGE",
            "Value of 'page.check.after.open' must be 'NONE', 'NEW_PAGE', 'EVERY_PAGE'."),
    SMART_LOCATORS("smart.locators", "((#%s|\\[[a-z]+=%s\\])[;, ]{0,1})+",
        "Value of 'smart.locators' must be a list of regular expressions."),
    CHROME_CAPABILITIES_PATH("chrome.capabilities.path", "^([A-z0-9-_+.]+\\/)*(chrome\\.properties)$",
            "Value of 'chrome.capabilities.path' must be a path to a chrome.options file."),
    FF_CAPABILITIES_PATH("ff.capabilities.path", "^([A-z0-9-_+.]+\\/)*(ff\\.properties)$",
            "Value of 'chrome.capabilities.path' must be a path to a ff.options file."),
    IE_CAPABILITIES_PATH("ie.capabilities.path", "^([A-z0-9-_+.]+\\/)*(ie\\.properties)$",
            "Value of 'chrome.capabilities.path' must be a path to a ie.options file.");

    private final String name;
    private final String check;
    private final String exMsg;

    Property(String name, String check, String exMsg) {
        this.name = name;
        this.check = check;
        this.exMsg = exMsg;
    }

    public String getName() {
        return name;
    }

    public String getCheck() {
        return check;
    }

    public String getExMsg() {
        return exMsg;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                '}';
    }
}
