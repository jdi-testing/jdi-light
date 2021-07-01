package com.epam.jdi.light.driver.get;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static java.lang.String.format;
import static java.lang.System.getenv;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RemoteDriverInfo {
    public static final String SELENIUM_LOCAL_HOST = "http://localhost:4444/wd/hub";
    public static final String SELENOID_LOCAL = "http://localhost:4444/wd/hub";
    public static String SAUCE_LABS = "http://ondemand.eu-central-1.saucelabs.com/wd/hub";
    public static String browserstack() {
        return browserstack(getenv("USERNAME"), getenv("ACCESS_KEY"));
    }
    public static String browserstack(String userName, String accessKey) {
        return getRemoteURL(format("https://%s:%s@hub-cloud.browserstack.com/", userName, accessKey));
    }
    public static String appium() {return getRemoteURL("http://0.0.0.0:4723/");}
    public static String getRemoteURL() {
        return getRemoteURL(DRIVER.remoteUrl);
    }
    public static String getRemoteURL(String remoteUrl) {
        try {
            if (!isBlank(remoteUrl)) {
                String url = remoteUrl.replaceAll("/+$", "/");
                if (!url.contains("wd/hub"))
                    url += "wd/hub/";
                return url;
            }
            throw exception("You run tests in Remote mode, please specify 'driver.remote.url' in test.properties");
        } catch(Exception ex) { throw exception(ex, "Can't get remote Url"); }
    }
}
