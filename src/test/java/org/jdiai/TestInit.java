package org.jdiai;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import static java.lang.Runtime.getRuntime;
import static java.lang.String.format;
import static java.util.Arrays.stream;

public class TestInit {
    static WebDriver DRIVER;
    static String HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";
    static String USERS_PAGE = "https://jdi-testing.github.io/jdi-light/user-table.html";
    private By defineLocator(String locator) {
        return locator.startsWith("//")
                ? By.xpath(locator)
                : By.cssSelector(locator);
    }
    public JSDriver js(String locator) {
        return new JSDriver(DRIVER, defineLocator(locator));
    }
    public JSDriver js(String... locators) {
        By[] list = stream(locators).map(this::defineLocator).toArray(By[]::new);
        return new JSDriver(DRIVER, list);
    }

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        try {
            getRuntime().exec(format("taskkill /F /IM chromedriver.exe /T"));
        } catch (Exception ignore) { }
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RomanJDI\\.m2\\repository\\webdriver\\chromedriver\\win32\\84.0.4147.30\\chromedriver.exe");
        DRIVER = new ChromeDriver();
        DRIVER.get(HOME_PAGE);
        DRIVER.manage().window().maximize();
    }
}
