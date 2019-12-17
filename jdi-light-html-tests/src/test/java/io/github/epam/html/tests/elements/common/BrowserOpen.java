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
        logger.info("Setting up driver");
        WebDriverManager.chromedriver().setup();
        logger.info("Driver is ready");
    }

    @Test
    public void before() {
        logger.info("Creating new Chromedriver");
        driver = new ChromeDriver();
        logger.info("Chromedriver instance has been created");
        logger.info("Opening page...");
        driver.get("https://jdi-testing.github.io/jdi-light/");
        logger.info("Page opened");
        logger.info("Getting page title");
        logger.info(driver.getTitle());
        driver.quit();

//        WebSettings.init();
//        WebDriverFactory.getDriver();
//        WebDriverUtils.killAllSeleniumDrivers();

    }

}
