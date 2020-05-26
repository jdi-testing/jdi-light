package nativeapp_ios;

import io.appium.java_client.AppiumDriver;
import nativeapp.ios.calendar.CalendarApp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class CalendarAppTestsInit {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initMobile(CalendarApp.class);
        logger.toLog("Run Tests");
    }

    @BeforeMethod
    public void openApp() {
        AppiumDriver driver = (AppiumDriver) getDriver();
        driver.launchApp();
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp() {
        AppiumDriver driver = (AppiumDriver) getDriver();
        driver.closeApp();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}
