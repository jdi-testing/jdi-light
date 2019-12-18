package io.github.epam.html.tests.elements.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static com.epam.jdi.light.driver.get.DriverData.DOWNLOADS_DIR;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class BrowserOpen {

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void getTextTest() {
        try {
            ChromeOptions options = new ChromeOptions();


            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            new File(DOWNLOADS_DIR).mkdirs();
            chromePrefs.put("download.default_directory", DOWNLOADS_DIR);
            chromePrefs.put("profile.default_content_setting_values.notifications", 0);
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("profile.password_manager_enabled", false);

            options.addArguments("--headless");
            options.setExperimentalOption("prefs", chromePrefs);

            ChromeDriver driver = new ChromeDriver(options);
            driver.get("google.com");
            logger.info(driver.getTitle());
            driver.quit();
        } catch (Exception ex) {
            logger.info("!!! " + ex.getMessage());
        }
    }
}
