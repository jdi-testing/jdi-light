package com.epam.jdi.light.common;

public enum Property {

    TIMEOUT_WAIT_ELEMENT("timeout.wait.element", "^[1-9][0-9]{1,2}$|^\\d$",
            "Value of 'timeout.wait.element' must be an integer from 0 to 999."),
    TIMEOUT_WAIT_PAGE("timeout.wait.page", "^[1-9][0-9]{1,2}$|^\\d$",
                                 "Value of 'timeout.wait.page' must be an integer from 0 to 999."),
    DOMAIN_PROPERTY("domain", "(https://|http://)?([a-zA-Z0-9|-]+[.][a-zA-Z0-9|-|.]+)[/]?(a-zA-Z0-9|-|.|/)*",
            "Value of 'domain' must be a string with URL type: consists characters, digits, '/', '.' in appropriate sequence.");


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
