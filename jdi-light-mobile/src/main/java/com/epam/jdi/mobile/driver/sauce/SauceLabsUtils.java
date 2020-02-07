package com.epam.jdi.mobile.driver.sauce;

import static com.epam.jdi.mobile.driver.WebDriverFactory.jsExecute;

public class SauceLabsUtils {
    public static void setSauceJobResult(boolean passed) {
        jsExecute("sauce:job-result=" + (passed ? "passed" : "failed"));
    }
}
