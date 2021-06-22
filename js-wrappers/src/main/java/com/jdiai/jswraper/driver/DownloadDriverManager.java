package com.jdiai.jswraper.driver;

import com.epam.jdi.tools.func.JFunc2;
import com.jdiai.jsdriver.JSException;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import static com.jdiai.jsbuilder.QueryLogger.logger;
import static com.jdiai.jswraper.driver.DriverManager.DOWNLOAD_SETTINGS;
import static com.jdiai.jswraper.driver.DriverManager.REMOTE_DRIVER_VERSIONS;
import static com.jdiai.jswraper.driver.DriverVersion.PENULT;
import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class DownloadDriverManager {
    static WebDriverManager wdm;

    static boolean hasVersion(String version) {
        if (isBlank(version)) {
            return false;
        }
        char c = version.charAt(0);
        return c >= '0' && c <= '9';
    }

    public static String downloadDriver(DriverTypes driverType, Platform platform) {
        try {
            String driverName = driverType.toString();
            switch (driverType) {
                case CHROME:
                    wdm = chromedriver(); break;
                case FIREFOX:
                    wdm = firefoxdriver(); break;
                case IE:
                    wdm = iedriver(); break;
                case IE_EDGE:
                    wdm = edgedriver(); break;
                case OPERA:
                    wdm = operadriver(); break;
                default:
                    throw new JSException("%s driver not supported for download", driverType);
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
            String version = REMOTE_DRIVER_VERSIONS.get(driverType);
            if (hasVersion(version)) {
                wdm = wdm.browserVersion(version);
                driverName += " " + version;
            }
            if (version.equalsIgnoreCase(PENULT.value)) {
                wdm.setup();
                wdm.browserVersion(getBelowVersion());
            }
            if (isNotBlank(DOWNLOAD_SETTINGS.gitHubTokenName) && isNotBlank(DOWNLOAD_SETTINGS.gitHubTokenSecret)) {
                wdm.gitHubTokenName(DOWNLOAD_SETTINGS.gitHubTokenName);
                wdm.gitHubTokenSecret(DOWNLOAD_SETTINGS.gitHubTokenSecret);
            }
            wdm.setup();
            logger.info("Download driver: '" +  driverName + "' successfully");
            DOWNLOAD_SETTINGS.downloadedDriverInfo = format("%s:%s:%s", driverType, platform, version);
            DOWNLOAD_SETTINGS.driverPath = wdm.getDownloadedDriverPath();
            return wdm.getDownloadedDriverPath();
        } catch (Exception ex) {
            throw new JSException(ex, "Can't download latest driver for " + driverType);
        }
    }

    public static JFunc2<DriverTypes, Platform, String> DOWNLOAD_DRIVER_FUNC =
            DownloadDriverManager::downloadDriver;

    public static String getBelowVersion() {
        String currentMajor = wdm.getDownloadedDriverVersion().split("\\.")[0];
        List<String> allVersions = wdm.getDriverVersions();
        for (int i = allVersions.size()-1; i>=0; i--) {
            if (parseInt(currentMajor) > parseInt(allVersions.get(i).split("\\.")[0]))
                return allVersions.get(i);
        }
        throw new JSException("Can't find version below current(" + wdm.getDownloadedDriverVersion()+")");
    }
}
