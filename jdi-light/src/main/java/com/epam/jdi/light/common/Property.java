package com.epam.jdi.light.common;

public enum Property {

    TIMEOUT_WAIT_ELEMENT("timeout.wait.element", "^[1-9][0-9]{1,2}$|^\\d$",
            "Value of 'timeout.wait.element' must be an integer from 0 to 999."),
    SCREENS_FOLDER("screens.folder", "^([A-z]:[\\\\\\/]|[\\\\\\/]|[\\w+\\.])+([\\w+\\.]+[\\\\\\/]|[\\w+\\.])+$", "'screens.folder' must contain the correct folder path"),
    KILL_BROWSER("browser.kill", "^afterAndBefore|after|before", "Value of 'browser.kill' must be one of the following:'afterAndBefore', 'after', 'before'"),
    ELEMENT_SEARCH_STRATEGY("element.search.strategy", "^strict|soft|visible, multiple|any, single", "Value of 'element.search.strategy' must be one of the following: 'strict', 'soft', 'visible, multiple', 'any, single'");


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
