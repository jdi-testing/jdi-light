package com.jdiai.jswraper.driver.remote;

import static java.lang.String.format;

public class BrowserStackOptions extends RemoteRunOptions {
    public BrowserStackOptions(String userName, String accessKey) {
        url = format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", userName, accessKey);
    }
}
