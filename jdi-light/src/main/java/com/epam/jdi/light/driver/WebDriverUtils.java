package com.epam.jdi.light.driver;

import com.epam.jdi.light.common.LinuxProcessUtils;
import com.epam.jdi.light.common.UnixProcessUtils;
import com.epam.jdi.tools.func.JAction1;

import java.io.IOException;

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
            } else if (os.contains("Linux")) {
                killAllLinuxOSDriverProcesses();
            } else {
                killAllWindowsDriverProcesses();
            }
        }
        catch (Exception ignore){
            logger.info("Can't kill driver processes");
        }
    }

    private static void killAllMacOSDriverProcesses() {
        killOSDriverProcesses(WebDriverUtils::killAllMacOSDriverProcessesByName,"firefox");
        killOSDriverProcesses(WebDriverUtils::killAllMacOSDriverProcessesByName,"chrome");
    }

    private static void killAllLinuxOSDriverProcesses() {
        killOSDriverProcesses(WebDriverUtils::killAllLinuxOSDriverProcessesByName, "chrome");
        killOSDriverProcesses(WebDriverUtils::killAllLinuxOSDriverProcessesByName,"firefox");
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

    private static void killOSDriverProcesses(JAction1<String> killDriverByProcessName, String browserName) {
        String processName = getDriverProcessName(browserName);
        if (processName != null) {
            killDriverByProcessName.execute(processName);
        }
    }

    private static String getDriverProcessName(String browserName){
        String name = null;
        switch (browserName.toLowerCase()) {
            case "firefox":
                name = "geckodriver";
                break;
            case "chrome":
                name = "chromedriver";
                break;

        }
        return name;
    }

    /**
     * @param driverName
     */
    private static void killAllMacOSDriverProcessesByName(String driverName) {
        UnixProcessUtils.killProcessesTree(driverName);
    }

    private static void killAllLinuxOSDriverProcessesByName(String driverName) {
        LinuxProcessUtils.killProcessesTree(driverName);
    }

}
