package com.epam.jdi.light.driver;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import java.io.IOException;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static org.openqa.selenium.os.WindowsUtils.killByName;

public final class WebDriverUtils {

    private WebDriverUtils() {
    }

    //TODO Add OS type and current user check.
    public static void killAllRunWebBrowsers() {
        try {
            killByName("chromedriver.exe");
            killByName("geckodriver.exe");
            killByName("IEDriverServer.exe");
            killByName("MicrosoftWebDriver.exe");
        } catch (Throwable ex) { logger.error("Can't kill drivers: ", ex.getMessage()); }
    }
}