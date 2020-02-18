package com.epam.jdi.light.driver.get;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.get.DriverData.PRELATEST_VERSION;
import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.driver.get.DriverInfo.getBelowVersion;
import static com.epam.jdi.light.driver.get.OsTypes.WIN;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.bonigarcia.wdm.WebDriverManager.*;

/**
 * Created by Roman_Iovlev on 11/28/2017.
 */
class DownloadDriverManager {
    private static boolean hasVersion(String version) {
        char c = version.charAt(0);
        return (c >= '0' && c <= '9');
    }
    static WebDriverManager wdm;

    static void downloadDriver(DriverTypes driverType,
          Platform platform, String version) {
        try {
            String driverName = driverType.toString();
            switch (driverType) {
                case CHROME:
                    wdm = chromedriver(); break;
                case FIREFOX:
                    wdm = firefoxdriver(); break;
                case IE:
                    wdm = iedriver(); break;
                case EDGE:
                    wdm = edgedriver(); break;
                case OPERA:
                    wdm = operadriver(); break;
                default:
                    throw exception("%s driver not supported for download");
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
            throw exception(ex, "Can't download latest driver for " + driverType);
        }
    }
}
