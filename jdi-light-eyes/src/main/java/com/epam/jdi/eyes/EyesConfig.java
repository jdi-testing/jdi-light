package com.epam.jdi.eyes;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.tools.StringUtils.format;
import static org.apache.commons.lang3.StringUtils.isBlank;

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
        } catch (Exception ignore) { }
        if (isBlank(batchName))
            batchName = format("%s %s", appName, Timer.nowDate());

    }
}
