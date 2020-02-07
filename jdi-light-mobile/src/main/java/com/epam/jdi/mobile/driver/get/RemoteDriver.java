package com.epam.jdi.mobile.driver.get;

import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.common.Exceptions.safeException;
import static java.lang.String.format;
import static java.lang.System.getenv;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RemoteDriver {
    public static String DRIVER_REMOTE_URL;
    public static String seleniumLocalhost() {
        return getRemoteURL("http://localhost:4444/");
    }
    public static String sauceLabs() {
        return getRemoteURL("http://ondemand.eu-central-1.saucelabs.com/");
    }
    public static String browserstack() {
        return browserstack(getenv("USERNAME"), getenv("ACCESS_KEY"));
    }
    public static String browserstack(String userName, String accessKey) {
        return getRemoteURL(format("https://%s:%s/@hub-cloud.browserstack.com/", userName, accessKey));
    }
    public static String getRemoteURL() {
        return getRemoteURL(DRIVER_REMOTE_URL);
    }
    public static String getRemoteURL(String remoteUrl) {
        try {
            if (!isBlank(remoteUrl)) {
                String url = remoteUrl.replaceAll("/*$", "/");
                if (!url.contains("wd/hub"))
                    url += "wd/hub/";
                return url;
            }
            throw exception("You run tests in Remote mode, please specify 'remote.url' in test.properties");
        } catch(Exception ex) { throw exception("Can't get remote Url: " + safeException(ex)); }
    }
}
