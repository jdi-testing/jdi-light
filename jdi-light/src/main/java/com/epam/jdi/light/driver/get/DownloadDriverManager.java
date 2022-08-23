package com.epam.jdi.light.driver.get;

import com.jdiai.tools.func.JFunc3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.get.DriverInfo.getBelowVersion;
import static com.epam.jdi.light.driver.get.DriverInfos.SAFARI_INFO;
import static com.epam.jdi.light.driver.get.DriverVersion.PENULT;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.StringUtils.format;
import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static org.apache.commons.lang.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman_Iovlev on 11/28/2017.
 */
public class DownloadDriverManager {
    private static boolean hasVersion(String version) {
        char c = version.charAt(0);
        return (c >= '0' && c <= '9');
    }
    static WebDriverManager wdm;
    public static boolean driverDownloaded = false;
    public static String downloadedDriverInfo;
    public static String driverPath;
    public static JFunc3<DriverTypes, Platform, String, String> DOWNLOAD_DRIVER_FUNC =
        DownloadDriverManager::downloadDriver;

    public static String downloadDriver(DriverTypes driverType, Platform platform, String version) {
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
                case SAFARI:
                    return isBlank(DRIVER.path)
                        ? SAFARI_INFO.path.execute()
                        : DRIVER.path;
                default:
                    throw runtimeException("%s driver not supported for download");
            }
            switch (platform) {
                case X32:
                    wdm = wdm.arch32();
                    break;
                case X64:
                    wdm = wdm.arch64();
                    break;
            }
            driverName += " " + platform;
            if (hasVersion(version)) {
                wdm = wdm.browserVersion(version);
                driverName += " " + version;
            }
            if (version.equalsIgnoreCase(PENULT.value)) {
                wdm.setup();
                wdm.browserVersion(getBelowVersion());
            }
            if (isNotBlank(DRIVER.gitHubToken)) {
                wdm.gitHubToken(DRIVER.gitHubToken);
            }
            wdm.setup();
            logger.info("Download driver: '" +  driverName + "' successfully");
            driverDownloaded = true;
            downloadedDriverInfo = format("%s:%s:%s", driverType, platform, version);
            driverPath = wdm.getDownloadedDriverPath();
            int timer = 1000;
            while (driverPath == null || driverPath.equals("") || driverPath.trim().equals("")) {
                Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(100));
                logger.info("Download driver step installation: '" +  driverPath + "' may wait: " + timer);
                timer -= 100;
                if(timer==0)
                    break;
            }

            return driverPath;
        } catch (Exception ex) {
            throw exception(ex, "Can't download latest driver for " + driverType);
        }
    }
}
