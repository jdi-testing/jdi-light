package org.jdiai;

import com.epam.jdi.tools.Safe;
import org.jdiai.jsdriver.JSDriver;
import org.jdiai.jselement.JSTalk;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.Runtime.getRuntime;
import static java.util.Arrays.stream;
import static org.jdiai.JSBuilder.LOG_QUERY;
import static org.jdiai.jselement.JSTalk.defineLocator;

public class TestInit {
    static Safe<WebDriver> DRIVER = new Safe(TestInit::initDriver);
    public static WebDriver driver() { return DRIVER.get(); }
    public static String HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";
    public static String USERS_PAGE = "https://jdi-testing.github.io/jdi-light/user-table.html";

    public JSDriver js(String locator) {
        return new JSDriver(driver(), defineLocator(locator));
    }
    public JSDriver js(String... locators) {
        By[] list = stream(locators).map(JSTalk::defineLocator).toArray(By[]::new);
        return new JSDriver(driver(), list);
    }

    protected String[] withParent(String locator) {
        return new String[] {".uui-header", ".profile-photo", locator };
    }
    protected String[] inForm(String locator) {
        return new String[] {".uui-header", "form", locator };
    }

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        killDrivers();
        LOG_QUERY = true;
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killDrivers();
    }

    protected void atHomePage() {
        driver().manage().deleteAllCookies();
        driver().get(HOME_PAGE);
    }
    protected void logout() {
        if (driver().manage().getCookieNamed("authUser") == null) {
            js("#user-name").invoke("click()");
            js("#name").invoke("value='Roman'");
            js("#password").invoke("value='Jdi1234'");
            js("#login-button").invoke("click()");
        }
        if (!driver().getCurrentUrl().equals(USERS_PAGE)) {
            driver().get(USERS_PAGE);
        }
    }

    private static WebDriver initDriver() {
        WebDriver driver = JSTalk.DRIVER.get();
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
