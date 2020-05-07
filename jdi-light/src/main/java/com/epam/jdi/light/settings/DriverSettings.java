package com.epam.jdi.light.settings;

import com.epam.jdi.light.driver.get.*;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.light.driver.WebDriverFactory.getWebDriverFactory;
import static com.epam.jdi.light.driver.get.DriverInfos.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;
import static com.epam.jdi.light.driver.get.DriverVersion.LATEST;
import static com.epam.jdi.light.driver.get.GetDriverTypes.DOWNLOAD;
import static com.epam.jdi.light.driver.get.Platform.X64;
import static com.epam.jdi.light.settings.CommonSettings.getCommonSettings;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;

public class DriverSettings {
    public String name;
    public String version;
    public OsTypes os;
    public Platform platform;
    public GetDriverTypes getType;
    public String path;
    public PageLoadStrategy pageLoadStrategy;
    public ScreenSize screenSize;
    public String domain;
    public String remoteUrl;
    public String downloadsFolder;

    public JFunc1<WebDriver, WebDriver> setup = DriverData::driverSettings;
    public MapArray<String, DriverInfo> types;
    public JFunc1<String, WebDriver> getFunc = getWebDriverFactory()::getDriverByName;
    public CapabilitiesSettings capabilities;

    public DriverSettings() {
        name = CHROME.name;
        version = LATEST.value;
        platform = X64;
        getType = DOWNLOAD;
        path = "C:/Selenium";
        pageLoadStrategy = NORMAL;
        screenSize = new ScreenSize();
        downloadsFolder = mergePath(getCommonSettings().testPath, "resources", "downloads");
        types = map(
                $(CHROME.name, CHROME_INFO),
                $(FIREFOX.name, FIREFOX_INFO),
                $(IE.name, IE_INFO),
                $(EDGE.name, EDGE_INFO),
                $(OPERA.name, OPERA_INFO),
                $(SAFARI.name, SAFARI_INFO)
        );
        capabilities = new CapabilitiesSettings();
    }
}
