package com.jdiai;

import static com.jdiai.DriverManager.driver;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class Pages {
    public static final String DOMAIN = "https://jdi-testing.github.io/jdi-light";
    // public static final String DOMAIN = "http://localhost:8000";
    public static String HOME_PAGE = DOMAIN + "/index.html";
    public static String USERS_PAGE = DOMAIN + "/user-table.html";

    public static void openSite() {
        if (driver().getCurrentUrl().equals("data:,")) {
            openPage(DOMAIN);
        }
    }

    public static void openPage(String url) {
        driver().get(getUrl(url));
    }
    private static String getUrl(String url) {
        return isEmpty(DOMAIN) || url.contains("//") ? url : DOMAIN + url;
    }
}
