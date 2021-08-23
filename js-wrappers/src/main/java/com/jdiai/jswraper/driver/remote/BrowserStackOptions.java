package com.jdiai.jswraper.driver.remote;

import org.openqa.selenium.MutableCapabilities;

import static com.epam.jdi.tools.StringUtils.format;

public class BrowserStackOptions extends RemoteRunOptions {
    public boolean local = false;

    public BrowserStackOptions(String userName, String accessKey) {
        url = format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", userName, accessKey);
    }

    @Override
    public void setOptions(MutableCapabilities options) {
        super.setOptions(options);
        options.setCapability("browserstack.local", local);
    }
}
