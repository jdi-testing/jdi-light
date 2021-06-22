package com.jdiai.jswraper.driver;

/**
 * Created by Roman Iovlev on 08.06.2021
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public enum RunModes {
    LOCAL_DOWNLOAD("localdownload"),
    LOCAL_BY_PATH("localbypath"),
    REMOTE("remote"),
    SELENIUM_GRID("selenium grid"),
    BROWSER_STACK("browserstack"),
    SELENOID("selenoid");

    public final String name;

    public static RunModes getByName(String name) {
        switch (name.toLowerCase().replaceAll("[^a-z\\s]", "")) {
            case "localdownload":
                return LOCAL_DOWNLOAD;
            case "localbypath":
                return LOCAL_BY_PATH;
            case "remote":
                return REMOTE;
            case "selenium":
                return SELENIUM_GRID;
            case "browserstack":
                return BROWSER_STACK;
            case "selenoid":
                return SELENOID;
            default:
                return LOCAL_DOWNLOAD;
        }
    }

    RunModes(String name) {
        this.name = name;
    }

}