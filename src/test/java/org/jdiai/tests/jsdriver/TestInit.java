package org.jdiai.tests.jsdriver;

import com.epam.jdi.tools.Safe;
import org.jdiai.jsdriver.JSDriver;
import org.jdiai.jsdriver.WebDriverByUtils;
import org.jdiai.jswraper.JSWrapper;
import org.jdiai.tools.JSTalk;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.Runtime.getRuntime;
import static java.util.Arrays.stream;
import static org.jdiai.jsdriver.WebDriverByUtils.defineLocator;
import static org.jdiai.jsdriver.jsbuilder.JSBuilder.LOG_QUERY;
import static org.jdiai.jswraper.JSWrapper.chromeDriver;
import static org.jdiai.tests.jsdriver.states.Pages.HOME_PAGE;
import static org.jdiai.tools.JSTalk.driver;

public class TestInit {
    public JSDriver js(String locator) {
        return new JSDriver(driver(), defineLocator(locator));
    }
    public JSDriver js(String... locators) {
        By[] list = stream(locators).map(WebDriverByUtils::defineLocator).toArray(By[]::new);
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
        JSTalk.DRIVER = new Safe<>(TestInit::initDriver);
        JSWrapper.DRIVER = JSTalk.DRIVER;
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killDrivers();
    }

    public static WebDriver initDriver() {
        WebDriver driver = chromeDriver();
        driver.get(HOME_PAGE);
        driver.manage().window().maximize();
        return driver;
    }
    public static void killDrivers() {
        try {
            getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignore) { }
    }
}
