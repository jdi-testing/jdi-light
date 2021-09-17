package com.epam.jdi.light.driver;

import com.epam.jdi.light.common.LinuxProcessUtils;
import com.epam.jdi.light.common.UnixProcessUtils;
import com.jdiai.tools.func.JAction1;

import java.io.IOException;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.StringUtils.format;
import static java.lang.Runtime.getRuntime;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public final class WebDriverUtils {
    private WebDriverUtils() {
    }

    /**
     * The method frees up resources, closes open browsers and stops Selenium drivers.
     * Use that method only if you sure, that in current test suite instance of web driver would not be required.
     * Be careful, method close browser as process, that mean, using this method with a Selenium Grid is not possible.
     * Use methods {@link WebDriverFactory#getDriver()} getDriver.quit()} or {@link WebDriverFactory#quit()}, instead of
     * {@link WebDriverUtils#killAllSeleniumDrivers()} to get a chance open and close browser in one test suite.
     *
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
        catch (Exception ignore) {
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

    private static String getDriverProcessName(String browserName) {
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
