package org.jdiai;

import com.epam.jdi.tools.Safe;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Runtime.getRuntime;
import static org.jdiai.Pages.HOME_PAGE;
import static org.jdiai.jswraper.JSWrapper.DRIVER;

public class DriverManager {
    public static void downloadDriver() {
        WebDriverManager wdm = chromedriver();
        wdm.arch64();
        // wdm.gitHubTokenName("WDM_GITHUBTOKENNAME");
        // wdm.gitHubTokenSecret("WDM_GITHUBTOKENSECRET");
        wdm.setup();
    }

    public static void initDriver() {
        downloadDriver();
        DRIVER = new Safe<>(() -> {
            WebDriver driver = chromeDriver();
            driver.get(HOME_PAGE);
            driver.manage().window().maximize();
            return driver;
        });
    }

    public static WebDriver chromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }
    public static void killDrivers() {
        try {
            getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignore) { }
    }
}
