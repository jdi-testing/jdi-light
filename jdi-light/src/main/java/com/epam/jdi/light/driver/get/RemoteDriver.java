package com.epam.jdi.light.driver.get;

import com.epam.jdi.light.common.Exceptions;

import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class RemoteDriver {
    public static String DRIVER_REMOTE_URL;
    public static URL getRemoteURL() {
        try {
            if (!isBlank(DRIVER_REMOTE_URL)) {
                String url = DRIVER_REMOTE_URL.replaceAll("/*$", "/");
                if (!url.contains("wd/hub"))
                    url += "wd/hub/";
                return new URL(url);
            }
            throw exception("You run tests in Remote mode, please specify 'remote.url' in test.properties");
        } catch(Exception ex) { throw exception("Can't get remote Url: " + safeException(ex)); }
    }
}
