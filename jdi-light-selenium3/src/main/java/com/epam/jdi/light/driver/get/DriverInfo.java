package com.epam.jdi.light.driver.get;

import com.jdiai.tools.DataClass;
import com.jdiai.tools.func.JFunc;
import com.jdiai.tools.func.JFunc1;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.DOWNLOAD_DRIVER_FUNC;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.wdm;
import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.driver.get.DriverVersion.LATEST;
import static com.epam.jdi.light.driver.get.OsTypes.WIN;
import static com.epam.jdi.light.driver.get.Platform.X32;
import static com.epam.jdi.light.driver.get.Platform.X64;
import static com.epam.jdi.light.driver.get.RemoteDriverInfo.getRemoteURL;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.LinqUtils.safeException;
import static com.jdiai.tools.StringUtils.format;
import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;
import static java.lang.System.setProperty;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

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
    public JFunc1<Capabilities, RemoteWebDriver> getRemoteDriver = caps -> {
        RemoteWebDriver driver = new RemoteWebDriver(new URL(getRemoteURL()), caps);
        driver.setFileDetector(new LocalFileDetector());
        return driver;
    };

    public boolean isLocal() {
        return DRIVER.remoteRun == null || !DRIVER.remoteRun;
    }
    public WebDriver getDriver() {
        logger.trace("getDriver(): " + this);
        return isLocal() ? setupLocal() : setupRemote();
    }
    private Capabilities getCapabilities() {
        return capabilities.execute(initCapabilities);
    }
    private WebDriver setupRemote() {
        try {
            logger.debug("setupRemote()");
            Capabilities caps = getCapabilities();
            logger.debug("getRemoteDriver.execute(caps: %s)", caps);
            return getRemoteDriver.execute(caps);
        } catch (Throwable ex) {
            throw exception(ex, "Failed to setup remote "+ downloadType.name+" driver");
        }
    }
    private Platform getDriverPlatform() {
        if (DRIVER.platform != null) {
            return DRIVER.platform;
        }
        if (getOs() == WIN || getProperty("os.arch").contains("32")) {
            return X32;
        }
        if (getProperty("os.arch").contains("64")) {
            return X64;
        }
        throw runtimeException("Unknown driver platform: %s. Only X32 or X64 allowed. Please specify exact platform in JDISettings.DRIVER.platform", getProperty("os.arch"));
    }
    private WebDriver setupLocal() {
        try {
            boolean emptyDriverPath = isBlank(DRIVER.path);
            logger.trace("setupLocal(): isBlank(DRIVER.path)="+emptyDriverPath);
            String driverPath = emptyDriverPath
                ? DOWNLOAD_DRIVER_FUNC.execute(downloadType, getDriverPlatform(), DRIVER.version)
                : path.execute();
            logger.info("Use driver path: " + driverPath);
            logger.trace("setProperty(properties:%s, driverPath:%s)", properties, driverPath);
            setProperty(properties, driverPath);
            Capabilities caps = getCapabilities();
            logger.trace("getDriver.execute(getCapabilities())", caps);
            return getDriver.execute(caps);
        } catch (Throwable ex) {
            try {
                if (isNotBlank(DRIVER.path) || !DRIVER.version.equals(LATEST.value)) {
                    throw exception(ex, safeException(ex));
                }
                logger.info("Failed to download driver (%s %s) of latest version:" +
                    "TRY TO GET DRIVER PREVIOUS VERSION", downloadType, DRIVER.version);
                return tryToDownloadDriver();
            } catch (Throwable ex2) {
                throw exception(ex2, "Failed to setup local driver");
            }
        }
    }

    private WebDriver tryToDownloadDriver() {
        try {
            DOWNLOAD_DRIVER_FUNC.execute(downloadType, getDriverPlatform(), getBelowVersion());
            return getDriver.execute(getCapabilities());
        } catch (Throwable ex) {
            throw exception(ex, "Failed to download driver");
        }
    }
    public static String getBelowVersion() {
        String currentMajor = wdm.getDownloadedDriverVersion().split("\\.")[0];
        List<String> allVersions = wdm.getDriverVersions();
        for (int i = allVersions.size()-1; i>=0; i--) {
            if (parseInt(currentMajor) > parseInt(allVersions.get(i).split("\\.")[0]))
                return allVersions.get(i);
        }
        throw runtimeException("Can't find version below current(" + wdm.getDownloadedDriverVersion()+")");
    }
    @Override
    public String toString() {
        return format("DriverInfo:[downloadType: %s; initCapabilities: %s; path: %s; properties: %s]", downloadType.name, initCapabilities, path.execute(), properties);
    }
}
