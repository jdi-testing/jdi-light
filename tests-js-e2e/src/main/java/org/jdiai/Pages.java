package org.jdiai;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.jdiai.tools.JSTalk.DOMAIN;

public class Pages {
    // public static final String DOMAIN = "http://localhost:8000";
    public static String HOME_PAGE = DOMAIN + "/index.html";

    public static WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/romaniovlev/Downloads/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }
}
