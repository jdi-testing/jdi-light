package com.epam.jdi.eyes;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.WebDriver;

public class EyesConfig extends DataClass<EyesConfig> {
    public String appName;
    public Configuration config;
    public JFunc<WebDriver> webDriver;
    public EyesRunner runner;
    public String apiKey;

    public EyesConfig() {
        appName = "JDI Application";
        config = new Configuration();
        config.setHideScrollbars(false);
        webDriver = WebDriverFactory::getDriver;
        runner = new ClassicRunner();
        try {
            apiKey = System.getenv("APPLITOOLS_API_KEY");
        } catch (Exception ignore) { }
    }
}
