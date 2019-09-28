package com.epam.jdi.light.driver.sauce;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public class SauceLabsUtils {
    public static void setSauceJobResult(boolean passed) {
        jsExecute("sauce:job-result=" + (passed ? "passed" : "failed"));
    }
}
