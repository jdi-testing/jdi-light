package com.epam.jdi.light.driver.get;

import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.driver.WebDriverFactory.isRemote;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.downloadDriver;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.wdm;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.RemoteDriver.getRemoteURL;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.Integer.parseInt;
import static java.lang.System.setProperty;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class DriverInfo extends DataClass<DriverInfo> {
    public DriverTypes type;
    public JFunc<Capabilities> capabilities;
    public String properties, path;
    public JFunc<WebDriver> getDriver;

    public WebDriver getDriver() {
        return isRemote()
                ? setupRemote()
                : setupLocal();
    }
    private WebDriver setupRemote() {
        try {
            return new RemoteWebDriver(getRemoteURL(), capabilities.execute());
        } catch (Exception ex) {
            throw exception("Failed to setup remote "+type.name+" driver");
        }
    }
    private WebDriver setupLocal() {
        try {
            if (isNotBlank(DRIVERS_FOLDER)) {
                setProperty(properties, path);
                logger.info("Get local driver: " + path);
            }
            else {
                downloadDriver(type, PLATFORM, DRIVER_VERSION);
            }
            return getDriver.execute();
        } catch (Exception ex) {
            try {
                if (isBlank(DRIVERS_FOLDER) && DRIVER_VERSION.equals(LATEST_VERSION)) {
                    logger.info("Failed to download driver (%s %s) of latest version:" +
                            "TRY TO GET DRIVER PREVIOUS VERSION", type, DRIVER_VERSION);
                    try {
                        downloadDriver(type, PLATFORM, getBelowVersion());
                        return getDriver.execute();
                    } catch (Exception ex2) { throw exception("Failed to download driver: " + ex2.getMessage()); }
                }
                throw exception(safeException(ex));
            } catch (Exception ex2) {
                throw exception("Failed to setup local driver: " + ex2.getMessage());
            }
        }
    }
    public static String getBelowVersion() {
        String currentMajor = wdm.getDownloadedVersion().split("\\.")[0];
        List<String> allVersions = wdm.getVersions();
        for (int i = allVersions.size()-1; i>=0; i--)
             if (parseInt(currentMajor) > parseInt(allVersions.get(i).split("\\.")[0]))
                 return allVersions.get(i);
         throw exception("Can't find version below current(" + wdm.getDownloadedVersion()+")");
    }
}
