package jdisite.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils {
    public static WebDriver DRIVER;

    public static void runChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
        DRIVER = new ChromeDriver();
        DRIVER.manage().window().maximize();
    }
}
