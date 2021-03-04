package org.jdiai;

import com.epam.jdi.tools.Safe;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class Pages {
    public static final String DOMAIN = "https://jdi-testing.github.io/jdi-light";
    // public static final String DOMAIN = "http://localhost:8000";
    public static String HOME_PAGE = DOMAIN + "/index.html";
    public static String USERS_PAGE = DOMAIN + "/user-table.html";

    public static Safe<WebDriver> DRIVER = new Safe<>(Pages::chromeDriver);

    public static void openSite() {
        openPage(DOMAIN);
    }
    public static void openPage(String url) {
        if (isEmpty(DOMAIN) || url.contains("//")) {
            driver().get(url);
        }
        else {
            driver().get(DOMAIN + url);
        }
    }
    public static WebDriver driver() {
        return DRIVER.get();
    }

    public static WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/romaniovlev/Downloads/chromedriver");
        // System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }
}
