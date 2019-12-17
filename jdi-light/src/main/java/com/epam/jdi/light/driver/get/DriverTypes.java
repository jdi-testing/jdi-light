package com.epam.jdi.light.driver.get;

import static com.epam.jdi.light.common.Exceptions.exception;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public enum DriverTypes {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    EDGE("edge"),
    OPERA("opera"),
    PHANTOMJS("phantomjs");

    public final String name;
    public static DriverTypes getByName(String name) {
        switch (name.toLowerCase()) {
            case "chrome": return CHROME;
            case "firefox": return FIREFOX;
            case "ie":
            case "internetexplorer":
                return IE;
            case "edge": return EDGE;
            case "phantom":
            case "opera": return OPERA;
            default:
                throw exception("Unknown driver: " + name);
        }
    }

    DriverTypes(String name) {
        this.name = name;
    }

}