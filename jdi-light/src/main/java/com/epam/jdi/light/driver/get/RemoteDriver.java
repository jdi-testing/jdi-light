package com.epam.jdi.light.driver.get;

import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class RemoteDriver {
    public static String DRIVER_REMOTE_URL;
//    public static String seleniumLocalhost() {
//        return getRemoteURL("http://localhost:4444/");
//    }
//    public static String sauceLabs() {
//        return getRemoteURL("http://ondemand.eu-central-1.saucelabs.com/");
//    }
//    public static String browserstack() {
//        return browserstack(getenv("USERNAME"), getenv("ACCESS_KEY"));
//    }
//    public static String browserstack(String userName, String accessKey) {
//        return getRemoteURL(format("https://%s:%s/@hub-cloud.browserstack.com/", userName, accessKey));
//    }

    public static URL getRemoteURL() {
        try {
            if (!isBlank(DRIVER_REMOTE_URL)) {
                String url = DRIVER_REMOTE_URL.replaceAll("/*$", "/");
                if (!url.contains("wd/hub"))
                    url += "wd/hub/";
                return new URL(url);
            }
            throw exception("You run tests in Remote mode, please specify 'remote.url' in test.properties");
        } catch (Exception ex) {
            throw exception("Can't get remote Url: " + safeException(ex));
        }
    }
}