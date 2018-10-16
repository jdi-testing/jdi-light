package com.epam.jdi.light.driver;

/**
 * Created by Roman Iovlev on 14.02.2018 Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import static org.openqa.selenium.os.WindowsUtils.killByName;

import com.epam.jdi.light.common.UnixProcessUtils;
import java.io.IOException;

public final class WebDriverUtils {


    private WebDriverUtils() {
    }

    /**
     * @throws IOException
     */
    public static void killAllBrowsersStartedBySelenium() {
        String os = System.getProperty("os.name");
        if (os.contains("Mac")) {
            killAllMacOSDriverProcesses();
        } else {
            killAllWindowsDriverProcesses();
        }
    }

    public static void killAllMacOSDriverProcesses() {
        killMacOSDriverProcesses("firefox");
        killMacOSDriverProcesses("chrome");
        killMacOSDriverProcesses("gecko");

    }

    /**
     *
     */
    private static void killAllWindowsDriverProcesses() {
        killByName("chromedriver.exe");
        killByName("geckodriver.exe");
        killByName("IEDriverServer.exe");
        killByName("MicrosoftWebDriver.exe");
    }

    private static void killMacOSDriverProcesses(String browserName) {

        String name = null;
        switch (browserName.toLowerCase()) {
            case "firefox":
            case "gecko":
                name = "geckodriver";
                break;
            case "chrome":
                name = "chromedriver";
                break;

        }
        if (name != null) {
            killAllMacOSDriverProcessesByName(name);
        }
    }

    /**
     * @param driverName
     */
    private static void killAllMacOSDriverProcessesByName(String driverName) {
            UnixProcessUtils.killProcessesTree(driverName);
    }

}