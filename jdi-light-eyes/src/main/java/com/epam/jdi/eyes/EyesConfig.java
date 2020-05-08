package com.epam.jdi.eyes;

/**
 * Created by Roman Iovlev on 11.04.2019
 * Email: roman.iovlev.jdi@gmail.com;
 * Skype: roman.iovlev
 */

import com.epam.jdi.light.common.VisualCheckAction;
import com.epam.jdi.light.common.VisualCheckPage;
import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.eyes.JDIEyes.EYES_CONFIG;
import static com.epam.jdi.light.driver.WebDriverFactory.getWebDriverFactory;
import static com.epam.jdi.light.settings.WebSettings.getWebSettings;
import static com.epam.jdi.tools.StringUtils.format;

public class EyesConfig extends DataClass<EyesConfig> {
    public String appName;
    public JFunc<WebDriver> webDriver;
    public String apiKey;
    public String batchName;

    public EyesConfig() {
        appName = "JDI Application";
        webDriver = getWebDriverFactory()::getDriver;
        try {
            apiKey = System.getenv("APPLITOOLS_API_KEY");
        } catch (Throwable ignore) { }
        batchName = format("%s %s", appName, Timer.nowDate());
    }
    public EyesConfig pageStrategy(VisualCheckPage checkPageStrategy) {
        getWebSettings().VISUAL_PAGE_STRATEGY = checkPageStrategy;
        return EYES_CONFIG;
    }
    public EyesConfig actionStrategy(VisualCheckAction checkActionStrategy) {
        getWebSettings().VISUAL_ACTION_STRATEGY = checkActionStrategy;
        return EYES_CONFIG;
    }
}
