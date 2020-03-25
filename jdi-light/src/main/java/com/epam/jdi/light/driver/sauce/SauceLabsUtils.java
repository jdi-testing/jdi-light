package com.epam.jdi.light.driver.sauce;

import static com.epam.jdi.light.driver.WebDriverFactory.*;

public class SauceLabsUtils {
    public static void setSauceJobResult(boolean passed) {
        jsExecute("sauce:job-result=" + (passed ? "passed" : "failed"));
    }
}
