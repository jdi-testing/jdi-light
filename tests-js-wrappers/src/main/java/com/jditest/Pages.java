package com.jdiai;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static com.jdiai.jswraper.JSWrapper.driver;

public class Pages {
    public static final String DOMAIN = "https://jdi-testing.github.io/jdi-light";
    // public static final String DOMAIN = "http://localhost:8000";
    public static String HOME_PAGE = DOMAIN + "/index.html";
    public static String USERS_PAGE = DOMAIN + "/user-table.html";
    public static String SIMPLE_PAGE = DOMAIN + "/simple-table.html";

    public static void openSite() {
        if (driver().getCurrentUrl().equals("data:,")) {
            openPage(DOMAIN);
        }
    }
    public static void openPage(String url) {
        if (isEmpty(DOMAIN) || url.contains("//")) {
            driver().get(url);
        }
        else {
            driver().get(DOMAIN + url);
        }
    }
}
