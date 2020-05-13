package com.epam.jdi.light.driver.get;

import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.*;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.DriverVersion.*;
import static com.epam.jdi.light.driver.get.OsTypes.*;
import static com.epam.jdi.light.driver.get.Platform.*;
import static com.epam.jdi.light.driver.get.RemoteDriver.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static java.lang.Integer.*;
import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;

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
        return isEmpty(DRIVER.remoteUrl) && (isNotBlank(DRIVER.path) && isNotBlank(path.execute()) || downloadType != null);
    }
    public WebDriver getDriver() {
        return isLocal()
            ? setupLocal()
            : setupRemote();
    }
    private Capabilities getCapabilities() {
        return capabilities.execute(initCapabilities);
    }
    private WebDriver setupRemote() {
        try {
            return getRemoteDriver != null
                ? getRemoteDriver.execute(getCapabilities())
                : new RemoteWebDriver(new URL(getRemoteURL()), getCapabilities());
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
            String driverPath = isBlank(DRIVER.path)
                ? downloadDriver(downloadType, getDriverPlatform(), DRIVER.version)
                : path.execute();
            logger.info("Use driver path: " + driverPath);
            setProperty(properties, driverPath);
            return getDriver.execute(getCapabilities());
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
        String currentMajor = wdm.getDownloadedVersion().split("\\.")[0];
        List<String> allVersions = wdm.getVersions();
        for (int i = allVersions.size()-1; i>=0; i--) {
            if (parseInt(currentMajor) > parseInt(allVersions.get(i).split("\\.")[0]))
                return allVersions.get(i);
        }
        throw exception("Can't find version below current(" + wdm.getDownloadedVersion()+")");
    }
}
