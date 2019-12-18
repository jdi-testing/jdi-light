package io.github.epam.html.tests.elements.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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


//            HashMap<String, Object> chromePrefs = new HashMap<>();
//            chromePrefs.put("credentials_enable_service", false);
//            chromePrefs.put("profile.password_manager_enabled", false);

            options.setHeadless(true);
//            options.setExperimentalOption("prefs", chromePrefs);

            ChromeDriver driver = new ChromeDriver(options);
//            driver.get("google.com");
//            logger.info(driver.getTitle());
//            driver.quit();
        } catch (Exception ex) {
            logger.info("!!! " + ex.getMessage());
        }
    }
}
