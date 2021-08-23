package com.jdiai.jswraper.driver.download;

import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.jswraper.driver.DriverTypes;
import com.jdiai.jswraper.driver.OsTypes;
import com.jdiai.jswraper.driver.Platform;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import static com.epam.jdi.tools.StringUtils.format;
import static com.jdiai.jsbuilder.QueryLogger.logger;
import static com.jdiai.jswraper.driver.DriverVersion.PENULT;
import static com.jdiai.jswraper.driver.GetDriverUtilities.getOs;
import static com.jdiai.jswraper.driver.GetDriverUtilities.hasVersion;
import static com.jdiai.jswraper.driver.JDIDriver.REMOTE_DRIVER_VERSIONS;
import static com.jdiai.jswraper.driver.JDIDriver.RUN_MODE;
import static com.jdiai.jswraper.driver.OsTypes.WIN;
import static com.jdiai.jswraper.driver.Platform.X32;
import static com.jdiai.jswraper.driver.Platform.X64;
import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class DownloadDriverSettings {
    public String gitHubTokenName;
    public String gitHubTokenSecret;
    public String downloadedDriverInfo;
    public String driverPath;
    public OsTypes os;
    public Platform platform;

    public String downloadDriver(DriverTypes driverType) {
        if (platform == null) {
            platform = getDriverPlatform();
        }
        WebDriverManager wdm;
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
                    throw new JDINovaException("%s driver not supported for download", driverType);
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
                wdm.browserVersion(getBelowVersion(wdm));
            }
            if (isNotBlank(gitHubTokenName) && isNotBlank(gitHubTokenSecret)) {
                wdm.gitHubTokenName(gitHubTokenName);
                wdm.gitHubTokenSecret(gitHubTokenSecret);
            }
            wdm.setup();
            logger.info("Download driver: '" +  driverName + "' successfully");
            downloadedDriverInfo = format("%s:%s:%s", driverType, platform, version);
            driverPath = wdm.getDownloadedDriverPath();
            return wdm.getDownloadedDriverPath();
        } catch (Exception ex) {
            throw new JDINovaException(ex, "Can't download latest driver for " + driverType);
        }
    }
    protected String getBelowVersion(WebDriverManager wdm) {
        String currentMajor = wdm.getDownloadedDriverVersion().split("\\.")[0];
        List<String> allVersions = wdm.getDriverVersions();
        for (int i = allVersions.size()-1; i>=0; i--) {
            if (parseInt(currentMajor) > parseInt(allVersions.get(i).split("\\.")[0]))
                return allVersions.get(i);
        }
        throw new JDINovaException("Can't find version below current(" + wdm.getDownloadedDriverVersion()+")");
    }

    private static Platform getDriverPlatform() {
        if (RUN_MODE.downloadSettings.platform != null) {
            return RUN_MODE.downloadSettings.platform;
        }
        if (getOs() == WIN || getProperty("os.arch").contains("32")) {
            return X32;
        }
        if (getProperty("os.arch").contains("64")) {
            return X64;
        }
        throw new JDINovaException("Unknown driver platform: %s. Only X32 or X64 allowed. Please specify exact platform in JDISettings.DRIVER.platform", getProperty("os.arch"));
    }
}
