package com.epam.jdi.light.driver.get;

import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.downloadDriver;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.wdm;
import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.driver.get.DriverVersion.LATEST;
import static com.epam.jdi.light.driver.get.OsTypes.WIN;
import static com.epam.jdi.light.driver.get.Platform.X32;
import static com.epam.jdi.light.driver.get.Platform.X64;
import static com.epam.jdi.light.driver.get.RemoteDriver.getRemoteURL;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.System.getProperty;
import static java.lang.System.setProperty;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverInfo extends DataClass<DriverInfo> {
    public DriverTypes downloadType;
    public MutableCapabilities initCapabilities = new DesiredCapabilities();
    public JFunc1<MutableCapabilities, Capabilities> capabilities = c -> c;
    public JFunc<String> path;
    public String properties;
    public JFunc1<Capabilities, WebDriver> getDriver;
    public JFunc1<Capabilities, WebDriver> getRemoteDriver;

    public boolean isLocal() {
        return !DRIVER.remoteRun;
    }
    public WebDriver getDriver() {
        logger.debug("getDriver(): " + toString());
        return isLocal()
            ? setupLocal()
            : setupRemote();
    }
    private Capabilities getCapabilities() {
        return capabilities.execute(initCapabilities);
    }
    private WebDriver setupRemote() {
        try {
            logger.debug("setupRemote()");
            Capabilities caps = getCapabilities();
            if (getRemoteDriver != null) {
                logger.debug("getRemoteDriver.execute(caps: %s)", caps);
                return getRemoteDriver.execute(caps);
            } else {
                logger.debug("new RemoteWebDriver(url:%s, caps: %s)", getRemoteURL(), caps);
                return new RemoteWebDriver(new URL(getRemoteURL()), caps);
            }
        } catch (Throwable ex) {
            throw exception(ex, "Failed to setup remote "+ downloadType.name+" driver");
        }
    }
    private Platform getDriverPlatform() {
        if (DRIVER.platform != null)
            return DRIVER.platform;
        if (getOs() == WIN || getProperty("os.arch").contains("32"))
            return X32;
        if (getProperty("os.arch").contains("64"))
            return X64;
        throw exception("Unknown driver platform: %s. Only X32 or X64 allowed. Please specify exact platform in JDISettings.DRIVER.platform", getProperty("os.arch"));
    }
    private WebDriver setupLocal() {
        try {
            boolean emptyDriverPath = isBlank(DRIVER.path);
            logger.debug("setupLocal(): isBlank(DRIVER.path)="+emptyDriverPath);
            String driverPath = emptyDriverPath
                ? downloadDriver(downloadType, getDriverPlatform(), DRIVER.version)
                : path.execute();
            logger.info("Use driver path: " + driverPath);
            logger.debug("setProperty(properties:%s, driverPath:%s)", properties, driverPath);
            setProperty(properties, driverPath);
            Capabilities caps = getCapabilities();
            logger.debug("getDriver.execute(getCapabilities())", caps);
            return getDriver.execute(caps);
        } catch (Throwable ex) {
            try {
                if (isBlank(DRIVER.path) && DRIVER.version.equals(LATEST.value)) {
                    logger.info("Failed to download driver (%s %s) of latest version:" +
                            "TRY TO GET DRIVER PREVIOUS VERSION", downloadType, DRIVER.version);
                    try {
                        downloadDriver(downloadType, getDriverPlatform(), getBelowVersion());
                        return getDriver.execute(getCapabilities());
                    } catch (Throwable ex2) { throw exception(ex2, "Failed to download driver"); }
                }
                throw exception(safeException(ex));
            } catch (Throwable ex2) {
                throw exception(ex2, "Failed to setup local driver");
            }
        }
    }
    public static String getBelowVersion() {
        String currentMajor = wdm.getDownloadedDriverVersion().split("\\.")[0];
        List<String> allVersions = wdm.getDriverVersions();
        for (int i = allVersions.size()-1; i>=0; i--) {
            if (parseInt(currentMajor) > parseInt(allVersions.get(i).split("\\.")[0]))
                return allVersions.get(i);
        }
        throw exception("Can't find version below current(" + wdm.getDownloadedDriverVersion()+")");
    }
    @Override
    public String toString() {
        return format("DriverInfo:[downloadType: %s; initCapabilities: %s; path: %s; properties: %s]", downloadType.name, initCapabilities, path.execute(), properties);
    }
}
