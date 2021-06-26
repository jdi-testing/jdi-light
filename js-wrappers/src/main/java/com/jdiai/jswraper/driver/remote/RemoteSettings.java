package com.jdiai.jswraper.driver.remote;

import com.jdiai.jswraper.driver.DriverTypes;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface RemoteSettings {
    default String url() {
        return "http://localhost:4444/wd/hub";
    }
    void setOptions(MutableCapabilities options);
    WebDriver getRemoteDriver(DriverTypes browser, MutableCapabilities options);

}
