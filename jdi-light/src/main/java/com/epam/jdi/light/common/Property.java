package com.epam.jdi.light.common;

public enum Property {

    TIMEOUT_WAIT_ELEMENT("timeout.wait.element", "^[1-9][0-9]{1,2}$|^\\d$",
            "Value of 'timeout.wait.element' must be an integer from 0 to 999."),
    BROWSER_SIZE_PROPERTY("browser.size", "MAXIMIZE|^([1-9][0-9]{2,3})x([1-9][0-9]{2,3})$",
            "Value of 'browser.size' must be 'MAXIMIZE' or two integers from 100 to 9999 between symbol 'x', " +
                    "for instance: 1920x1080."),
    PAGE_LOAD_STRATEGY("page.load.strategy", "normal|eager|none",
            "Value of 'page.load.strategy' must be 'normal', 'eager' or 'none'."),
    PAGE_CHECK_AFTER_OPEN("page.check.after.open", "NONE|NEW_PAGE|EVERY_PAGE",
            "Value of 'page.check.after.open' must be 'NONE', 'NEW_PAGE', 'EVERY_PAGE'."),
    SMART_LOCATORS("smart.locators", "((#%s|\\[[a-z]+=%s\\])[;, ]{0,1})+",
            "Value of 'smart.locators' must be a list of regular expressions."),
    CHROME_CAPABILITIES_PATH("chrome.capabilities.path", "^([\\w-.]+[\\\\\\/])*(chrome\\.properties)$",
            "Value of 'chrome.capabilities.path' must be a path to a chrome.properties file."),
    FF_CAPABILITIES_PATH("ff.capabilities.path", "^([\\w-.]+[\\\\\\/])*(ff\\.properties)$",
            "Value of 'ff.capabilities.path' must be a path to a ff.properties file."),
    IE_CAPABILITIES_PATH("ie.capabilities.path", "^([\\w-.]+[\\\\\\/])*(ie\\.properties)$",
            "Value of 'ie.capabilities.path' must be a path to a ie.properties file."),
    DRIVER("driver", "^\\$\\{driver\\}$|chrome|firefox|ie",
            "driver parameter value is incorrect. Valid values are: 'chrome', 'firefox', 'ie' or '${driver}'"),
    DRIVERS_VERSION("drivers.version", "LATEST|PRELATEST|^([0-9])+([.][0-9]{1,3}[.][a-zA-Z0-9_-]+)$",
            "drivers.version parameter value is incorrect."),
    DRIVERS_FOLDER_PATH("drivers.folder", "^([a-zA-Z]:[\\\\\\/]+)([\\w-_]+|[\\w-_]+[\\\\\\/]+)*?$",
            "Value of 'drivers.folder' must be absolute path to drivers directory"),
    SCREENS_FOLDER("screens.folder", "^([A-z]:[\\\\\\/]|[\\\\\\/]|[\\w+\\.])+([\\w+\\.]+[\\\\\\/]|[\\w+\\.])+$",
            "Value of 'screens.folder' must be the correct folder path"),
    KILL_BROWSER_PROPERTY("browser.kill", "afterAndBefore|after|before",
            "Value of 'browser.kill' must be one of the following:'afterAndBefore', 'after', 'before'"),
    ELEMENT_SEARCH_STRATEGY("element.search.strategy", "strict|soft|visible, multiple|any,\\s?single",
            "Value of 'element.search.strategy' must be one of the following: 'strict', 'soft', 'visible, multiple', 'any, single'");

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
