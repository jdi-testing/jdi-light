package com.epam.jdi.light.driver.get;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.tools.Switch;

import java.io.File;

import static com.epam.jdi.light.driver.get.OsTypes.LINUX;
import static com.epam.jdi.light.driver.get.OsTypes.MAC;
import static com.epam.jdi.light.driver.get.OsTypes.WIN;
import static com.epam.jdi.light.driver.get.Platform.X32;
import static com.epam.jdi.tools.LinqUtils.Switch;

public class DriverData {
    public static final String PROJECT_PATH = new File("").getAbsolutePath() + "\\src";
    public static final String SRC_PATH = PROJECT_PATH + "\\main";
    public static final String TEST_PATH = PROJECT_PATH + "\\test";
    public static String LOGS_PATH = TEST_PATH + "\\.logs";
    public static String DRIVERS_FOLDER = SRC_PATH + "\\resources\\drivers\\";
    public static String chromeDriverPath() { return mergePath(DRIVERS_FOLDER,
        getOs() == WIN ? "chromedriver.exe" : "chromedriver"); }
    public static String ieDriverPath() { return mergePath(DRIVERS_FOLDER,
        "IEDriverServer.exe"); }
    public static String edgeDriverPath() { return mergePath(DRIVERS_FOLDER,
        "MicrosoftWebDriver.exe"); }
    public static String operaDriverPath() { return mergePath(DRIVERS_FOLDER,
        getOs() == WIN ? "operadriver.exe" : "operadriver"); }
    public static String phantomDriverPath() { return mergePath(DRIVERS_FOLDER,
        getOs() == WIN ? "phantomjs.exe" : "phantomjs"); }
    public static String firefoxDriverPath() { return mergePath(DRIVERS_FOLDER,
        getOs() == WIN ? "geckodriver.exe" : "geckodriver"); }

    public static String DRIVER_VERSION = "LATEST";
    public static Platform PLATFORM = X32;

    public static OsTypes getOs() {
        String osName = System.getProperty("os.name").toLowerCase();
        return Switch(osName).get(
            Switch.Case(os -> os.contains("mac"), MAC),
            Switch.Case(os -> os.contains("win") || os.contains("ms"), WIN),
            Switch.Default(LINUX)
        );
    }
    public static String mergePath(String path, String suffix) {
        return path.replaceAll("/", "\\").replaceAll("\\*$", "") +
                "\\" + suffix.replaceAll("/", "\\").replaceAll("^\\*", "");
    }
}
