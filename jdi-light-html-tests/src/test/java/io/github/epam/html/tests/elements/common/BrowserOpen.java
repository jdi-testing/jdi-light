package io.github.epam.html.tests.elements.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class BrowserOpen {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void before() {

        driver = new ChromeDriver();
        driver.get("https://jdi-testing.github.io/jdi-light/");
        logger.info(driver.getTitle());
        driver.quit();

//        WebSettings.init();
//        WebDriverFactory.getDriver();
//        WebDriverUtils.killAllSeleniumDrivers();

    }

}
