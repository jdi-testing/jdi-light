package com.epam.jdi.light.driver.get;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_VERSION;
import static com.epam.jdi.light.driver.get.DriverData.PLATFORM;

/**
 * Created by Roman_Iovlev on 11/28/2017.
 */
public class DownloadDriverManager {
    public static boolean DOWNLOAD_DRIVER = true;

    private static boolean hasVersion() {
        char c = DRIVER_VERSION.charAt(0);
        return (c >= '0' && c <= '9');
    }

    public static void downloadDriver(DriverTypes driverType) {
        WebDriverManager wdm;
        try {
            switch (driverType) {
                case CHROME:
                    wdm = WebDriverManager.chromedriver(); break;
                case FIREFOX:
                    wdm = WebDriverManager.firefoxdriver(); break;
                case IE:
                    wdm = WebDriverManager.iedriver(); break;
                case EDGE:
                    wdm = WebDriverManager.edgedriver(); break;
                case PHANTOMJS:
                    wdm = WebDriverManager.phantomjs(); break;
                case OPERA:
                    wdm = WebDriverManager.operadriver(); break;
                default:
                    throw exception("Unknown driver: " + driverType);
            }
            switch (PLATFORM) {
                case X32: wdm = wdm.arch32(); break;
                case X64: wdm = wdm.arch64(); break;
            }
            if (hasVersion())
                wdm = wdm.version(DRIVER_VERSION);
            wdm.setup();
        } catch (Exception ex) {
            throw exception("Can't download latest driver for " + driverType
                    + ". Exception " + ex.getMessage());
        }
    }
}
