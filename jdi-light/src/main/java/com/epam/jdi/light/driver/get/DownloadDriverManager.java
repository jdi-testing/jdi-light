package com.epam.jdi.light.driver.get;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.DriverInfo.*;
import static com.epam.jdi.light.driver.get.DriverVersion.*;
import static com.epam.jdi.light.driver.get.OsTypes.*;
import static com.epam.jdi.light.settings.WebSettings.*;
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

    static String downloadDriver(DriverTypes driverType, Platform platform, String version) {
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
            // wdm.config().getProperty("wdm.targetPath");
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
            if (version.equalsIgnoreCase(PENULT.value)) {
                wdm.setup();
                wdm.version(getBelowVersion());
            }
            wdm.setup();
            logger.info("Download driver: '" +  driverName + "' successfully");
            return wdm.getBinaryPath();
        } catch (Exception ex) {
            throw exception(ex, "Can't download latest driver for " + driverType);
        }
    }
}
