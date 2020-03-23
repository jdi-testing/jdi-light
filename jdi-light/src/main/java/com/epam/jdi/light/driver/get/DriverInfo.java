package com.epam.jdi.light.driver.get;

import com.epam.jdi.tools.DataClass;
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
    public String properties, path;
    public JFunc1<Capabilities, WebDriver> getDriver;
    public JFunc1<Capabilities, WebDriver> getRemoteDriver;

    public boolean isLocal() {
        return isEmpty(DRIVER.remoteUrl) && (isNotBlank(DRIVER.path) && isNotBlank(path) || downloadType != null);
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
                : new RemoteWebDriver(new URL(getRemoteURL()), getCapabilities());        } catch (Throwable ex) {
            throw exception(ex, "Failed to setup remote "+ downloadType.name+" driver");
        }
    }
    private WebDriver setupLocal() {
        try {
            String driverPath = isBlank(DRIVER.path)
                ? downloadDriver(downloadType, PLATFORM, DRIVER.version)
                : path;
            logger.info("Use driver path: " + driverPath);
            setProperty(properties, driverPath);
            return getDriver.execute(getCapabilities());
        } catch (Throwable ex) {
            try {
                if (isBlank(DRIVER.path) && DRIVER.version.equals(LATEST.value)) {
                    logger.info("Failed to download driver (%s %s) of latest version:" +
                            "TRY TO GET DRIVER PREVIOUS VERSION", downloadType, DRIVER.version);
                    try {
                        downloadDriver(downloadType, PLATFORM, getBelowVersion());
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
