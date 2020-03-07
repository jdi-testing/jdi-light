package com.epam.jdi.eyes;

/**
 * Created by Roman Iovlev on 11.04.2019
 * Email: roman.iovlev.jdi@gmail.com;
 * Skype: roman.iovlev
 */

import com.epam.jdi.light.common.*;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.*;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.eyes.JDIEyes.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.StringUtils.*;

public class EyesConfig extends DataClass<EyesConfig> {
    public String appName;
    public JFunc<WebDriver> webDriver;
    public String apiKey;
    public String batchName;

    public EyesConfig() {
        appName = "JDI Application";
        webDriver = WebDriverFactory::getDriver;
        try {
            apiKey = System.getenv("APPLITOOLS_API_KEY");
        } catch (Throwable ignore) { }
        batchName = format("%s %s", appName, Timer.nowDate());
    }
    public EyesConfig pageStrategy(VisualCheckPage checkPageStrategy) {
        VISUAL_PAGE_STRATEGY = checkPageStrategy;
        return EYES_CONFIG;
    }
    public EyesConfig actionStrategy(VisualCheckAction checkActionStrategy) {
        VISUAL_ACTION_STRATEGY = checkActionStrategy;
        return EYES_CONFIG;
    }
}
