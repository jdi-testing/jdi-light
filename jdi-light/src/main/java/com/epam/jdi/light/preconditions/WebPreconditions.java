package com.epam.jdi.light.preconditions;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.settings.WebSettings.DOMAIN;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface WebPreconditions extends IPreconditions {
    static boolean checkUrl(String uri) {
        return getDriver().getCurrentUrl().matches(".*/" + uri + "(\\?.*)?");
    }

    static void openUri(String uri) {
        getDriver().navigate().to(getUrlByUri(uri));
    }

    static String getUrlByUri(String uri) {
        return DOMAIN.replaceAll("/*$", "") + "/" + uri.replaceAll("^/*", "");
    }

    default void open() {
        moveToAction();
    }
}