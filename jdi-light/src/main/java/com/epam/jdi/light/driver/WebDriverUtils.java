package com.epam.jdi.light.driver;

/**
 * Created by Roman Iovlev on 14.02.2018 Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import java.io.IOException;

import static org.openqa.selenium.os.WindowsUtils.killByName;

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

    private static void killMacOSDriverProcesses(String driverName) {

        String name = null;
        switch (driverName.toLowerCase()) {
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
        try {
            Process child = new ProcessBuilder(
                "pkill ",
                "-9 -P | pgrep ",
                driverName)
                .start();
            child.waitFor();

            Process process = new ProcessBuilder(
                "pkill -9",
                "-afi",
                driverName)
                .start();
            process.waitFor();

        } catch (IOException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }

}