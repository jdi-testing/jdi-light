package com.epam.jdi.light.settings;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.*;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.light.driver.get.DriverInfos.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;
import static com.epam.jdi.light.driver.get.DriverVersion.*;
import static com.epam.jdi.light.driver.get.GetDriverTypes.*;
import static com.epam.jdi.light.driver.get.Platform.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.tools.PathUtils.*;
import static com.epam.jdi.tools.map.MapArray.*;
import static com.epam.jdi.tools.pairs.Pair.*;
import static org.openqa.selenium.PageLoadStrategy.*;

public class DriverSettings {
    public String name = CHROME.name;
    public String version = LATEST.value;
    public OsTypes os;
    public Platform platform = X64;
    public GetDriverTypes getType = DOWNLOAD;
    public String path = "C:/Selenium";
    public PageLoadStrategy pageLoadStrategy = NORMAL;
    public ScreenSize screenSize = new ScreenSize();
    public String domain;
    public String remoteUrl;
    public String downloadsFolder = mergePath(COMMON.testPath, "resources", "downloads");

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
