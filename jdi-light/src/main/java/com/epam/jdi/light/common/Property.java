package com.epam.jdi.light.common;

public enum Property {

    TIMEOUT_WAIT_ELEMENT("timeout.wait.element", "^[1-9][0-9]{1,2}$|^\\d$",
            "Value of 'timeout.wait.element' must be an integer from 0 to 999."),

    DRIVER("driver", "^\\${driver}$|^chrome$|^firefox$|^ie$", "driver parameter value is incorrect"),

    DRIVERS_VERSION("drivers.version", "LATEST|PRELATEST|[0-9]+[.][0-9][0-9]", "drivers.version parameter value is incorrect"),

    DRIVERS_FOLDER("drivers.folder", "^([A-z]:[\\\\\\/]|[\\\\\\/]|[\\w+\\.])+([\\w+\\.]+[\\\\\\/]|[\\w+\\.])+$", "drivers.folder parameter value is incorrect");

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
