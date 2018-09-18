package com.epam.jdi.light.driver.get;

import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.isRemote;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.downloadDriver;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_VERSION;
import static com.epam.jdi.light.driver.get.DriverData.PLATFORM;
import static com.epam.jdi.light.settings.WebSettings.DRIVER_REMOTE_URL;
import static java.lang.System.setProperty;

public class DriverInfo extends DataClass<DriverInfo> {
    public DriverTypes type;
    public JFunc<Capabilities> capabilities;
    public String properties;
    public String path;
    public JFunc<WebDriver> getDriver;

    public WebDriver getDriver() {
        return isRemote()
                ? setupRemote()
                : setupLocal();
    }
    private WebDriver setupRemote() {
        try {
            return new RemoteWebDriver(new URL(DRIVER_REMOTE_URL), capabilities.execute());
        } catch (Exception ex) { throw exception("Can't get remote "+type.name+" driver"); }
    }
    private WebDriver setupLocal() {
        if (DRIVER_VERSION.isEmpty())
            setProperty(properties, path);
        else
            downloadDriver(type, PLATFORM, DRIVER_VERSION);
        return getDriver.execute();
    }
}
