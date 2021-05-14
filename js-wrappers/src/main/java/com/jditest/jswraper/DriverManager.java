package com.jditest.jswraper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.function.Consumer;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Runtime.getRuntime;

public class DriverManager {
    public static Consumer<WebDriver> DRIVER_SETUP = driver -> {
        driver.manage().window().maximize();
    };
    public static Consumer<MutableCapabilities> COMMON_OPTIONS = cap -> { };
    public static Consumer<ChromeOptions> CHROME_OPTIONS = co -> { };
    public static void downloadDriver() {
        WebDriverManager wdm = chromedriver();
        wdm.arch64();
        // wdm.gitHubTokenName("WDM_GITHUBTOKENNAME");
        // wdm.gitHubTokenSecret("WDM_GITHUBTOKENSECRET");
        wdm.setup();
    }

    public static WebDriver chromeDriver() {
        downloadDriver();
        ChromeOptions options = new ChromeOptions();
        COMMON_OPTIONS.accept(options);
        CHROME_OPTIONS.accept(options);
        WebDriver driver = new ChromeDriver(options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static void killDrivers() {
        try {
            getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignore) { }
    }
}
