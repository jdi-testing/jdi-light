package com.jdiai.jswraper.driver.remote;

import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.jswraper.driver.DriverTypes;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

import static com.jdiai.jswraper.driver.GetDriverUtilities.hasVersion;
import static com.jdiai.jswraper.driver.JDIDriver.REMOTE_DRIVER_VERSIONS;

public class RemoteRunOptions implements RemoteSettings {
    public RemoteRunOptions() {
        this("http://localhost:4444/wd/hub");
    }

    public RemoteRunOptions(String url) {
        this.url = url;
    }
    public String url;
    public String name;
    public String build;
    public String platform;
    public boolean network = false;
    public boolean console = false;
    public boolean visual = false;
    public boolean video = false;

    public WebDriver getRemoteDriver(DriverTypes browser, MutableCapabilities options) {
        try {
            options.setCapability("browserName", browser.name);
            String version = REMOTE_DRIVER_VERSIONS.get(browser);
            if (hasVersion(version)) {
                options.setCapability("version", version);
            }
            setOptions(options);
            if (url == null || !url.contains("http")) {
                throw new JDINovaException("Failed to run driver remote, please check REMOTE_RUN_OPTIONS.url");
            }
            return new RemoteWebDriver(URI.create(url).toURL(), options);
        } catch (Exception ex) {
            throw new JDINovaException(ex, "Failed to run local driver '%s'", browser.name);
        }
    }

    public void setOptions(MutableCapabilities options) {
        if (name != null) {
            options.setCapability("name", name);
        }
        if (build != null) {
            options.setCapability("build", build);
        }
        if (platform != null) {
            options.setCapability("platform", platform);
        }
        options.setCapability("network", network);
        options.setCapability("console", console);
        options.setCapability("visual", visual);
        options.setCapability("video", video);
    }
}
