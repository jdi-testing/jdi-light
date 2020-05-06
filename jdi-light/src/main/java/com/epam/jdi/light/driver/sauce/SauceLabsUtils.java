package com.epam.jdi.light.driver.sauce;

import static com.epam.jdi.light.driver.WebDriverFactory.getWebDriverFactory;

public class SauceLabsUtils {
    public static void setSauceJobResult(boolean passed) {
        getWebDriverFactory().jsExecute("sauce:job-result=" + (passed ? "passed" : "failed"));
    }
}
