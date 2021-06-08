package com.jdiai.jswraper.driver;

import com.jdiai.jsdriver.JSException;

/**
 * Created by Roman Iovlev on 08.06.2021
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public enum DriverTypes {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    IE_EDGE("ieedge"),
    OPERA("opera"),
    SAFARI("safari");

    public final String name;
    public static DriverTypes getByName(String name) {
        switch (name.toLowerCase().replaceAll("[^a-z\\s]", "")) {
            case "chrome":
                return CHROME;
            case "firefox":
                return FIREFOX;
            case "ie":
            case "internetexplorer":
                return IE;
            case "ieedge":
            case "edge":
                return IE_EDGE;
            case "opera":
                return OPERA;
            case "safari":
                return SAFARI;
            default:
                throw new JSException("Unknown driver: " + name);
        }
    }

    DriverTypes(String name) {
        this.name = name;
    }

}