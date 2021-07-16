package utils;

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
    DRIVER_PROPERTY("driver", "^\\$\\{driver\\}$|chrome|firefox|ie",
        "driver parameter value is incorrect. Valid values are: 'chrome', 'firefox', 'ie' or '${driver}'"),
    DRIVER_VERSION_PROPERTY("driver.version", "LATEST|PRELATEST|^([0-9])+([.][0-9]{1,3}[.][a-zA-Z0-9_-]+)$",
        "driver.version parameter value is incorrect."),
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
    SCREENSHOT_STRATEGY_PROPERTY("screenshot.strategy", "off|on fail|on assert|new page",
        "Value of 'screenshot.strategy' must be: 'off', 'on fail', 'on assert' or 'new page'."),
    HTML_CODE_STRATEGY_PROPERTY("html.code.strategy", "off|on fail|on assert|new page",
        "Value of 'html.code.strategy' must be: 'off', 'on fail', 'on assert' or 'new page'."),
    REQUESTS_STRATEGY_PROPERTY("requests.strategy", "off|on fail|on assert|new page",
        "Value of 'requests.strategy' must be: 'off', 'on fail', 'on assert' or 'new page'."),
    ALLURE_STEPS_PROPERTY("allure.steps", "true|false",
        "Value of 'requests.strategy' must be either 'true' or 'false'."),
    TEXT_TYPE_PROPERTY("text.type", "SMART_TEXT|TEXT|VALUE|INNER|LABEL",
        "Value of 'text.type' must be: 'SMART_TEXT', 'TEXT', 'VALUE', 'INNER' or 'LABEL'."),
    SET_TEXT_TYPE_PROPERTY("set.text.type", "SET_TEXT|SEND_KEYS|CLEAR_SEND_KEYS",
        "Value of 'set.text.type' must be: 'SET_TEXT', 'SEND_KEYS' or 'CLEAR_SEND_KEYS'."),
    REMOTE_TYPE_PROPERTY("remote.type", "sauce|browserstack|saucelabs|selenium_localhost",
        "Value of 'remote.type' must be: 'sauce', 'browserstack', 'saucelabs' or 'selenium_localhost'."),
    SMART_LOCATORS_TO_NAME_PROPERTY("smart.locators.toName", "kebab-case|camelCase|snake_case|PascalCase|UPPER_SNAKE_CASE",
        "Value of 'smart.locators.toName' must be: 'kebab-case', 'camelCase', 'snake_case', 'PascalCase' or 'UPPER_SNAKE_CASE'."),
    HEADLESS_PROPERTY("headless", "true|false",
        "Value of 'headless' must be: 'true' or 'false'."),
    STRATEGY_PROPERTY("strategy", "jdi|jdi-stable|selenium",
        "Value of 'strategy' must be: 'jdi', 'jdi-stable' or 'selenium'."),
    CLICK_TYPE_PROPERTY("click.type", "SMART_CLICK|TOP_LEFT|TOP_RIGHT|BOTTOM_LEFT|BOTTOM_RIGHT|CENTER|JS",
        "Value of 'click.type' must be: 'SMART_CLICK', 'TOP_LEFT', 'TOP_RIGHT', 'BOTTOM_LEFT', 'BOTTOM_RIGHT', 'CENTER' or 'JS'."),
    SMART_SEARCH_PROPERTY("smart.search", "false|onlyui|uiandelements|always",
        "Value of 'smart.search' must be: 'false', 'onlyui', 'uiandelements' or 'always'."),
    LOG_INFO_DETAILS_PROPERTY("log.info.details", "NONE|NAME|LOCATOR|CONTEXT|ELEMENT",
        "Value of 'log.info.details' must be: 'NONE', 'NAME', 'LOCATOR', 'CONTEXT' or 'ELEMENT'."),
    LIST_START_INDEX_PROPERTY("list.start.index", "^[1-9][0-9]{1,2}$|^\\d$",
        "Value of 'list.start.index' must be an integer from 0 to 999."),
    CHROME_CAPABILITIES_PATH("chrome.capabilities.path", "^([\\w-.]+[\\\\\\/])*(chrome\\.properties)$",
        "Value of 'chrome.capabilities.path' must be a path to a chrome.properties file."),
    FF_CAPABILITIES_PATH("ff.capabilities.path", "^([\\w-.]+[\\\\\\/])*(ff\\.properties)$",
        "Value of 'ff.capabilities.path' must be a path to a ff.properties file."),
    EDGE_CAPABILITIES_PATH("edge.capabilities.path", "^([\\w-.]+[\\\\\\/])*(edge\\.properties)$",
        "Value of 'edge.capabilities.path' must be a path to a edge.properties file."),
    OPERA_CAPABILITIES_PATH("opera.capabilities.path", "^([\\w-.]+[\\\\\\/])*(opera\\.properties)$",
        "Value of 'opera.capabilities.path' must be a path to a opera.properties file."),
    SAFARI_CAPABILITIES_PATH("safari.capabilities.path", "^([\\w-.]+[\\\\\\/])*(safari\\.properties)$",
        "Value of 'safari.capabilities.path' must be a path to a safari.properties file."),
    COMMON_CAPABILITIES_PATH("common.capabilities.path", "^([\\w-.]+[\\\\\\/])*(common\\.properties)$",
        "Value of 'common.capabilities.path' must be a path to a common.properties file."),
    IE_CAPABILITIES_PATH("ie.capabilities.path", "^([\\w-.]+[\\\\\\/])*(ie\\.properties)$",
        "Value of 'ie.capabilities.path' must be a path to a ie.properties file.");


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
