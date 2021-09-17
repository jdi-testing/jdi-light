package com.epam.jdi.light.settings;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.*;
import com.jdiai.tools.func.JFunc1;
import com.jdiai.tools.map.MapArray;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.light.driver.get.DriverInfos.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;
import static com.epam.jdi.light.driver.get.DriverVersion.LATEST;
import static com.epam.jdi.light.driver.get.GetDriverTypes.DOWNLOAD;
import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.jdiai.tools.PathUtils.mergePath;
import static com.jdiai.tools.map.MapArray.map;
import static com.jdiai.tools.pairs.Pair.$;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;

public class DriverSettings {
    public String name = CHROME.name;
    public String version = LATEST.value;
    public OsTypes os;
    public Platform platform;
    public GetDriverTypes getType = DOWNLOAD;
    public String path;
    public PageLoadStrategy pageLoadStrategy = NORMAL;
    public ScreenSize screenSize = new ScreenSize();
    public String domain;
    public String siteName;
    public String remoteUrl;
    public Boolean remoteRun = null;
    public String downloadsFolder = mergePath(COMMON.testPath, "resources", "downloads");
    public String videoUrl;
    public String gitHubToken;

    public JFunc1<WebDriver, WebDriver> setup = DriverData::driverSettings;
    public MapArray<String, DriverInfo> types = map(
        $(CHROME.name, CHROME_INFO),
        $(FIREFOX.name, FIREFOX_INFO),
        $(IE.name, IE_INFO),
        $(EDGE.name, EDGE_INFO),
        $(OPERA.name, OPERA_INFO),
        $(SAFARI.name, SAFARI_INFO)
    );
    public JFunc1<String, WebDriver> getFunc = WebDriverFactory::getDriverByName;
    public CapabilitiesSettings capabilities = new CapabilitiesSettings();
}
