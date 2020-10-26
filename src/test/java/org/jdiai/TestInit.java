package org.jdiai;

import com.epam.jdi.tools.Safe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.Runtime.getRuntime;
import static java.util.Arrays.stream;

public class TestInit {
    static Safe<WebDriver> DRIVER = new Safe(TestInit::initDriver);
    public static WebDriver driver() { return DRIVER.get(); }
    public static String HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";
    public static String USERS_PAGE = "https://jdi-testing.github.io/jdi-light/user-table.html";
    private By defineLocator(String locator) {
        return locator.contains("//")
            ? By.xpath(locator)
            : By.cssSelector(locator);
    }
    public JSDriver js(String locator) {
        return new JSDriver(driver(), defineLocator(locator));
    }
    public JSDriver js(String... locators) {
        By[] list = stream(locators).map(this::defineLocator).toArray(By[]::new);
        return new JSDriver(driver(), list);
    }

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        killDrivers();
        JSDriver.logQuery = true;
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killDrivers();
    }

    private static WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(HOME_PAGE);
        driver.manage().window().maximize();
        return driver;
    }
    private static void killDrivers() {
        try {
            getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignore) { }
    }
}
