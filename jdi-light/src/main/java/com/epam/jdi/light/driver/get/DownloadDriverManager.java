package com.epam.jdi.light.driver.get;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.driver.get.DriverData.PRELATEST_VERSION;
import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.driver.get.DriverInfo.getBelowVersion;
import static com.epam.jdi.light.driver.get.OsTypes.WIN;
import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * Created by Roman_Iovlev on 11/28/2017.
 */
public class DownloadDriverManager {
    public static boolean DOWNLOAD_DRIVER = true;

    private static boolean hasVersion(String version) {
        char c = version.charAt(0);
        return (c >= '0' && c <= '9');
    }
    public static WebDriverManager wdm;

    public static void downloadDriver(DriverTypes driverType,
                                      Platform platform, String version) {
        try {
            String driverName = driverType.toString();
            switch (driverType) {
                case CHROME:
                    wdm = WebDriverManager.chromedriver(); break;
                case FIREFOX:
                    wdm = WebDriverManager.firefoxdriver(); break;
                case IE:
                    wdm = WebDriverManager.iedriver(); break;
                case EDGE:
                    wdm = WebDriverManager.edgedriver(); break;
                case OPERA:
                    wdm = WebDriverManager.operadriver(); break;
                default:
                    throw exception("Unknown driver: " + driverType);
            }
            if (getOs() == WIN) {
                switch (platform) {
                    case X32:
                        wdm = wdm.arch32();
                        break;
                    case X64:
                        wdm = wdm.arch64();
                        break;
                }
                driverName += " " + platform;
            }
            if (hasVersion(version)) {
                wdm = wdm.version(version);
                driverName += " " + version;
            }
            if (version.equalsIgnoreCase(PRELATEST_VERSION)) {
                wdm.setup();
                wdm.version(getBelowVersion());
            }
            wdm.setup();
            logger.info("Download driver: '" +  driverName + "' successfully");
        } catch (Exception ex) {
            throw exception("Can't download latest driver for " + driverType
                    + ". Exception " + safeException(ex));
        }
    }
}