package com.epam.jdi.light.common;

public enum Property {

    TIMEOUT_WAIT_ELEMENT_PROPERTY("timeout.wait.element", "^[1-9][0-9]{1,2}$|^\\d$",
            "Value of 'timeout.wait.element' must be an integer from 0 to 999."),
    BROWSER_SIZE_PROPERTY("browser.size", "MAXIMIZE|^([1-9][0-9]{2,3})x([1-9][0-9]{2,3})$",
            "Value of 'browser.size' must be 'MAXIMIZE' or two integers from 100 to 9999 between symbol 'x', " +
                    "for instance: 1920x1080."),
    PAGE_LOAD_STRATEGY_PROPERTY("page.load.strategy", "normal|eager|none",
            "Value of 'page.load.strategy' must be 'normal', 'eager' or 'none'."),
    PAGE_CHECK_AFTER_OPEN("page.check.after.open", "NONE|NEW_PAGE|EVERY_PAGE",
            "Value of 'page.check.after.open' must be 'NONE', 'NEW_PAGE', 'EVERY_PAGE'."),
    SMART_LOCATORS_PROPERTY("smart.locators", "((#%s|\\[[a-z]+=%s\\])[;, ]{0,1})+",
            "Value of 'smart.locators' must be a list of regular expressions."),
    CHROME_CAPABILITIES_PATH("chrome.capabilities.path", "^([\\w-.]+[\\\\\\/])*(chrome\\.properties)$",
            "Value of 'chrome.capabilities.path' must be a path to a chrome.properties file."),
    FF_CAPABILITIES_PATH("ff.capabilities.path", "^([\\w-.]+[\\\\\\/])*(ff\\.properties)$",
            "Value of 'ff.capabilities.path' must be a path to a ff.properties file."),
    IE_CAPABILITIES_PATH("ie.capabilities.path", "^([\\w-.]+[\\\\\\/])*(ie\\.properties)$",
            "Value of 'ie.capabilities.path' must be a path to a ie.properties file."),
    DRIVER_PROPERTY("driver", "^\\$\\{driver\\}$|chrome|firefox|ie",
            "driver parameter value is incorrect. Valid values are: 'chrome', 'firefox', 'ie' or '${driver}'"),
    DRIVERS_VERSION_PROPERTY("drivers.version", "LATEST|PRELATEST|^([0-9])+([.][0-9]{1,3}[.][a-zA-Z0-9_-]+)$",
            "drivers.version parameter value is incorrect."),
    DRIVERS_FOLDER_PROPERTY("drivers.folder", "^([a-zA-Z]:[\\\\\\/]+)([\\w-_]+|[\\w-_]+[\\\\\\/]+)*?$",
            "Value of 'drivers.folder' must be absolute path to drivers directory"),
    SCREENS_FOLDER_PROPERTY("screens.folder", "^([A-z]:[\\\\\\/]|[\\\\\\/]|[\\w+\\.])+([\\w+\\.]+[\\\\\\/]|[\\w+\\.])+$",
            "Value of 'screens.folder' must be the correct folder path"),
    KILL_BROWSER_PROPERTY("browser.kill", "afterAndBefore|after|before",
            "Value of 'browser.kill' must be one of the following:'afterAndBefore', 'after', 'before'"),
    ELEMENT_SEARCH_STRATEGY_PROPERTY("element.search.strategy", "strict|soft|visible, multiple|any,\\s?single",
            "Value of 'element.search.strategy' must be one of the following: 'strict', 'soft', 'visible, multiple', 'any, single'"),
    TIMEOUT_WAIT_PAGE_PROPERTY("timeout.wait.page", "^[1-9][0-9]{1,2}$|^\\d$",
            "Value of 'timeout.wait.page' must be an integer from 0 to 999."),
    DOMAIN_PROPERTY("domain", "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*[\\.|:][a-z0-9]{2,5}(:[0-9]{1,5})?([\\w+\\/\\-\\.])*?$",
            "Value of 'domain' must be a string with URL type: consists characters, digits, '/', '.' or ':' in appropriate sequence."),
    ASSERT_TYPE_PROPERTY("assert.type", "soft|strict",
            "Value of 'assert.type' must be either 'soft' or 'strict'."),
    DRIVER_REMOTE_URL_PROPERTY("driver.remote.url", "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*[\\.|:][a-z0-9]{2,5}(:[0-9]{1,5})?([\\w+\\/\\-\\.])*?$",
            "Value of 'driver.remote.url' must be a string with URL type: consists characters, digits, '/', '.' or ':' in appropriate sequence."),
    LOG_LEVEL_PROPERTY("log.level", "OFF|FATAL|ERROR|WARNING|STEP|INFO|DEBUG|TRACE|ALL",
            "Value of 'log.level' must be: 'OFF', 'FATAL', 'ERROR', 'WARNING', 'STEP', 'INFO', 'DEBUG', 'TRACE' or 'ALL'."),
    SCREENSHOT_STRATEGY_PROPERTY("screenshot.strategy", "off|on|on fail",
            "Value of 'screenshot.strategy' must be either 'off', 'on' or 'on fail'.");


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
