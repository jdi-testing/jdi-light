package com.epam.jdi.light.driver;

import java.io.IOException;

import static com.epam.jdi.light.common.UnixProcessUtils.killProcessesTree;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.Runtime.getRuntime;
import static java.lang.String.format;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public final class WebDriverUtils {


    private WebDriverUtils() {
    }

    /**
     * @throws IOException
     */
    public static void killAllSeleniumDrivers() {
        String os = System.getProperty("os.name");
        try {
            if (os.contains("Mac")) {
                killAllMacOSDriverProcesses();
            } else {
                killAllWindowsDriverProcesses();
            }
        }
        catch (Exception ignore){
            logger.info("Can't kill driver processes");
        }
    }

    private static void killAllMacOSDriverProcesses() {
        killMacOSDriverProcesses("firefox");
        killMacOSDriverProcesses("chrome");
    }

    /**
     *
     */
    private static void killAllWindowsDriverProcesses() throws IOException {
        killByName("chromedriver");
        killByName("geckodriver");
        killByName("IEDriverServer");
        killByName("MicrosoftWebDriver");
    }
	
    private static void killByName(String value) throws IOException {
        getRuntime().exec(format("taskkill /F /IM %s.exe /T", value));
    }

    private static void killMacOSDriverProcesses(String browserName) {
        String name = null;
        switch (browserName.toLowerCase()) {
            case "firefox":
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
            killProcessesTree(driverName);
    }

}